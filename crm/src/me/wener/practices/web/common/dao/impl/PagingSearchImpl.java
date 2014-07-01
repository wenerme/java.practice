package me.wener.practices.web.common.dao.impl;

import com.googlecode.genericdao.search.Search;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.wener.practices.web.common.dao.AbstractPaging;
import me.wener.practices.web.common.dao.BaseDao;

@Accessors(chain = true)
@ToString
public class PagingSearchImpl<T> extends AbstractPaging<T>
{
    @Setter
    protected BaseDao<T, ?> dao;

    @Getter
    private Search search;

    @SuppressWarnings("unchecked")
    public PagingSearchImpl(BaseDao<T, ?> dao, Search search)
    {
        this.search = search;
        this.dao = dao;
        setPageSize(DEFAULT_PAGE_SIZE);
        if (getCurrentPage() < 0)
            setCurrentPage(0);

        setType(dao.getType());
    }

    @Override
    public int getPageSize()
    {
        return search.getMaxResults();
    }

    @Override
    public PagingSearchImpl<T> setPageSize(int pageSize)
    {
        search.setMaxResults(pageSize);
        return this;
    }

    @Override
    public long getItemCount()
    {
        return dao.count(search);
    }

    @Override
    public int getCurrentPage()
    {
        return search.getPage();
    }

    @Override
    public PagingSearchImpl<T> setCurrentPage(int currentPage)
    {
        search.setPage(currentPage);
        return this;
    }

    /**
     * @return 当前页的项目列表
     */
    @Override
    public List<T> getItems()
    {
        return dao.search(search);
    }
}
