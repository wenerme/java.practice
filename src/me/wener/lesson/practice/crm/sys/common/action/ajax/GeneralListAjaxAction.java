package me.wener.lesson.practice.crm.sys.common.action.ajax;


import com.opensymphony.xwork2.ActionContext;
import me.wener.lesson.practice.crm.sys.common.action.GeneralListAction;
import me.wener.lesson.practice.crm.sys.common.dao.ISearchCondition;

public abstract class GeneralListAjaxAction<T, C extends ISearchCondition>
        extends GeneralListAction<T, C> implements IGeneralAjaxAction
{
    @Override
    public String list() throws Exception
    {
        super.list();
        setWrappedData(new AjaxPaging<>(getPage()));

        return WRAPPED_JSON;
    }

    @Override
    public Object getWrappedData()
    {
        return ActionContext.getContext().get(DATA_KEY);
    }

    @Override
    public void setWrappedData(Object data)
    {
        ActionContext.getContext().put(DATA_KEY, data);
    }
}
