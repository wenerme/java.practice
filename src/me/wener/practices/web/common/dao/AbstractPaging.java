package me.wener.practices.web.common.dao;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public abstract class AbstractPaging<T> implements Paging<T>
{
    @Setter(AccessLevel.PROTECTED)
    @Getter
    Class<T> type;

    @Override
    public int getPageCount()
    {
        return (int)Math.ceil((double)getItemCount()/getPageSize());
    }

    @Override
    public int getCurrentPageCount()
    {
        return getCurrentPage() + 1;
    }

    @Getter
    @Setter
    private int pageSize;

    @Getter
    @Setter
    private int currentPage;

    public int getFirstResultIndex()
    {
        return getCurrentPage()*getPageSize();
    }
}
