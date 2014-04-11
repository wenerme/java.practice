package me.wener.lesson.practice.crm.sys.common.action.ajax;

import me.wener.lesson.practice.crm.sys.common.dao.IPaging;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;

import java.sql.SQLException;
import java.util.List;

public class AjaxPaging<T> implements IPaging<T>
{
    private Paging<T> page;

    public AjaxPaging(Paging<T> page)
    {
        this.page = page;
    }

    @Override
    public long getCurrentPageNo()
    {
        return page.getCurrentPageNo();
    }

    @Override
    public long getPageCount()
    {
        return page.getPageCount();
    }

    @Override
    public List<T> getItems() throws SQLException
    {
        return page.getItems();
    }

    @Override
    public boolean hasNext()
    {
        return page.hasNext();
    }

    @Override
    public List<T> next()
    {
        return page.next();
    }

    @Override
    public void remove()
    {
        page.remove();
    }
}
