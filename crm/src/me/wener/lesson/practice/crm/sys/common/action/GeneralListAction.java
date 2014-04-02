package me.wener.lesson.practice.crm.sys.common.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import me.wener.lesson.practice.crm.sys.common.dao.IGeneralService;
import me.wener.lesson.practice.crm.sys.common.dao.ISearchCondition;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;

public abstract class GeneralListAction<T, C extends ISearchCondition>
        extends ActionSupport implements ServletRequestAware
{
    @Getter
    @Setter
    private HttpServletRequest servletRequest;
    @Getter
    @Setter
    private String id = null;
    @Setter
    private String ids[] = null;
    @Getter
    @Setter
    private Long pageNo = null;
    @Getter
    @Setter
    private T item = null;
    @Setter
    private C condition = null;
    @Getter
    private Class<T> itemType;
    @Getter
    private Class<C> conditionType;

    @SuppressWarnings("unchecked")// 确保类型的正确
    protected GeneralListAction()
    {
        ParameterizedType su = (ParameterizedType) this.getClass().getGenericSuperclass();
        itemType = (Class<T>) su.getActualTypeArguments()[0];
        conditionType = (Class<C>) su.getActualTypeArguments()[1];
    }

    /**
     * 如果 ids 为null而id不为null,则会返回包含 id 的单元素数组
     * 如果 ids 和 id 同时为 null,则会返回空数组
     */
    protected String[] getIds()
    {
        if (ids == null)
        {
            if (id != null)
                return new String[]{id};
            else
                return new String[0];
        }
        return ids;
    }

    /**
     * 显示列表操作,接受 pageNo 操作
     */
    public String list() throws Exception
    {
        // getPage 能确保 page 有值
        if (pageNo != null)
            getPage().setCurrentPageNo(pageNo);
        else
            getPage();

        return SUCCESS;
    }

    /**
     * 删除操作,接受id或ids,ids优先
     */
    public String delete() throws Exception
    {
        IGeneralService service = getService();

        for (String id : getIds())
            service.delete(Integer.parseInt(id));

        return SUCCESS;
    }

    /**
     * 添加操作
     */
    public String add() throws Exception
    {
        if (item == null)
            return INPUT;
        else if (getService().exists(item))// 如果该条目已经存在,则使用 edit
            return ERROR;// TODO 该项目已经存在

        getService().add(item);
        return SUCCESS;
    }


    /**
     * 编辑
     */
    public String edit() throws Exception
    {
        if (item == null || isGet())
        {
            T editItem = null;// 编辑对象

            try
            {
                editItem = getService().id(Integer.parseInt(id));
            } catch (NumberFormatException ignored)
            {
            }// 有可能 id 错误

            if (editItem == null)
            {
                // TODO 错误处理,编辑的项目不存在
                return ERROR;
            }
            // 设置 editItem
            ActionContext.getContext().put("item", editItem);// 这个不需要放在 Session 里

            return INPUT;
        }

        if (! getService().exists(item))
            return  ERROR;// TODO 该条项目不存在

        getService().update(item);
        return SUCCESS;
    }

    /**
     * 搜索操作
     */
    public String search() throws Exception
    {
        if (getCondition() != null)// 只有在有条件时才进行搜索
        {
            setPage(getService().search(getCondition()));
            ActionContext.getContext().getSession().put("condition", getCondition());
        }
        return SUCCESS;
    }

    /**
     * 重置搜索条件
     */
    public String searchReset() throws Exception
    {
        setCondition(null);
        setPage(getService().all());
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")// 已判断 object 转换到 page 的正确性
    protected Paging<T> getPage() throws Exception
    {
        Object o = ActionContext.getContext().getSession().get("page");
        Paging<T> page;
        if (o instanceof Paging && ((Paging) o).getType().equals(getItemType()))
        {
            page = (Paging<T>) o;
        } else
        {
            page = getService().all();
        }
        ActionContext.getContext().getSession().put("page", page);

        return page;
    }

    protected void setPage(Paging<T> page) throws Exception
    {
        if (page == null)
            throw new NullPointerException("Page must not null.");

        ActionContext.getContext().getSession().put("page", page);
    }

    @SuppressWarnings("unchecked")// 已经确保了类型转换的正确性
    public C getCondition() throws IllegalAccessException, InstantiationException
    {
        // 必须确保 condition 类型正确
        if (condition != null)
            return condition;

        Object o = ActionContext.getContext().getSession().get("condition");

        if (o != null && conditionType.isAssignableFrom(o.getClass()))
            condition = (C) o;
        else
            condition = conditionType.newInstance();

        ActionContext.getContext().getSession().put("condition", condition);

        return condition;
    }

    protected boolean isGet()
    {
        return servletRequest.getMethod().equals("GET");
    }

    protected boolean isPost()
    {
        return servletRequest.getMethod().equals("POST");
    }

    protected abstract IGeneralService<T, C> getService();
}
