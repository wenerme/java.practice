package me.wener.practices.web.common.action;


import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.wener.practices.web.common.dao.Paging;
import me.wener.practices.web.common.service.BaseService;

@ToString
public abstract class ListDominateAction<SVC extends BaseService<T, Long>, T> extends BasicModelAction<SVC, T, Long>
{
    protected static final String EDIT = "edit";
    protected static final String ADD = "add";
    protected static final String TO_LIST = "toList";
    protected static final String SEARCH = "search";

    @Setter
    @Getter
    private String ids[] = new String[0];

    @Getter
    @Setter
    private Integer pageNo = null;


    /**
     * 显示列表操作,接受 pageNo 操作
     */
    public String list() throws Exception
    {
        // getPage 能确保 page 有值
        if (pageNo != null)
            getPage().setCurrentPage(pageNo);
        else
            getPage();

        return SUCCESS;
    }

    public String add() throws Exception
    {
        if (isGet())
            return ADD;
        String result = handleAdd();
        return result != null ? result : TO_LIST;
    }

    protected String handleAdd()
    {
        service().save(model());
        return null;
    }

    public String delete() throws Exception
    {
        String result = handleDelete();
        return result != null ? result : TO_LIST;
    }

    public String edit() throws Exception
    {
        if (isGet())
        {
            Long id = null;
            try
            {
                id = Long.parseLong(ids[0]);
            } catch (Exception ignored)
            {
            }

            if (id == null)
            {
                addActionError("编辑的项目不存在.");
                return TO_LIST;
            }

            // 手动压入model
            ActionContext.getContext().getValueStack().push(service().id(id));

            return EDIT;
        } else
        {
            String result = handleEdit();
            if (Strings.isNullOrEmpty(result))
                return TO_LIST;
            else
                return result;
        }
    }

    @SuppressWarnings("unchecked")// 已经确保了转换的正确性
    protected Paging<T> getPage() throws Exception
    {
        Object o = session("page");
        Paging<T> page;
        if (o instanceof Paging && ((Paging) o).getType().isAssignableFrom(service().getType()))
        {
            page = (Paging<T>) o;
        } else
        {
            page = getListPage();// 获取显示的列表页
        }
        setPage(page);// 将page保存在session 中

        return page;
    }

    protected void setPage(Paging<T> page) throws Exception
    {
        session("page", page);
    }

    /**
     * 由子类来完成编辑的逻辑
     *
     * @return 返回 null 或空字符串则由该类决定返回值,否则返回返回值
     */
    protected String handleEdit()
    {
        return null;
    }

    /**
     * 获取在 List 页显示的 Paging
     */
    protected Paging<T> getListPage()
    {
        return service().page();
    }

    protected String handleDelete()
    {
        for (String id : ids)
        {
            service().delete(Long.parseLong(id));
        }
        return null;
    }
}
