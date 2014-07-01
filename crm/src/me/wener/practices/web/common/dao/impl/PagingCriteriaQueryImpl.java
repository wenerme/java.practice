package me.wener.practices.web.common.dao.impl;


import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import lombok.Setter;
import me.wener.practices.web.common.dao.AbstractDao;
import me.wener.practices.web.common.dao.AbstractPaging;

public class PagingCriteriaQueryImpl<T> extends AbstractPaging<T>
{

    @Setter
    private CriteriaQuery<T> query;
    @Setter
    private CriteriaQuery<Long> counter;
    @Setter
    private AbstractDao<?, ?> dao;

    public PagingCriteriaQueryImpl(CriteriaQuery<T> query, CriteriaQuery<Long> counter, AbstractDao<?, ?> dao)
    {
        this.query = query;
        this.counter = counter;
        this.dao = dao;
        setType(query.getResultType());
    }

    @Override
    public long getItemCount()
    {
        return dao.one(counter);
    }

    @Override
    public List<T> getItems()
    {
        return dao.getQuery(query)
                .setFirstResult(getFirstResultIndex())
                .setMaxResults(getPageSize())
                .getResultList();
    }
}
