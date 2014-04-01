package me.wener.lesson.practice.crm.sys.common.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import me.wener.lesson.practice.crm.sys.common.dao.ISearchCondition;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.common.dao.IGeneralService;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

public abstract class GeneralListAction<T>
        extends ActionSupport
{
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

    @Getter
    @Setter
    private ISearchCondition condition = null;

    private Class<T> type;

    protected GeneralListAction()
    {
        ParameterizedType su = (ParameterizedType) this.getClass().getGenericSuperclass();
        type = (Class<T>) su.getActualTypeArguments()[0];
    }

    /**
     * 如果 ids 为null而id不为null,则会返回包含 id 的单元素数组
     * 如果 ids 和 id 同时为 null,则会返回空数组
     */
    public String[] getIds()
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
        System.out.println("In list type is "+ type);
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();
        session.put("page", getService().findAll());

        return this.SUCCESS;
    }

    /**
     * 删除操作,接受id或ids,ids优先
     *
     * @return
     * @throws Exception
     */
    public String delete() throws Exception
    {
        IGeneralService service = getService();

        for (String id : getIds())
            service.delete(Integer.parseInt(id));

        return this.SUCCESS;
    }

    /**
     * 添加操作
     * @return 如果 item 为 null,会返回 gotoPage
     */
    public String add() throws Exception
    {
        if (item == null)
            return "gotoPage";
        getService().add(item);
        return this.SUCCESS;
    }


    public String search() throws Exception
    {

        return this.SUCCESS;
    }

    protected Paging<T> getPage() throws Exception
    {
        Object o = ActionContext.getContext().getSession().get("page");
        Paging<T> page = null;
        if (o instanceof Paging && ((Paging) o).getType().equals(getType()))
        {
            page = (Paging<T>) o;
        } else
        {
            page = getService().findAll();
        }

        return page;
    }

    protected abstract IGeneralService<T> getService();

    protected Class<T> getType()
    {
        return type;
    }
}
