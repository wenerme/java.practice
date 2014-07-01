package me.wener.practices.web.common.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import lombok.Setter;
import me.wener.practices.web.common.dao.AbstractPaging;

/**
 * 包装 TypedQuery 实现的分页, 但是不知道为何,一个 TypedQuery 只能查询一次,
 * 查询后再次查询会出现 EntityManager 已关闭的异常
 * @param <T> 实体类型
 */
public class PagingTypedQueryImpl<T> extends AbstractPaging<T>
{
    @Setter
    private TypedQuery<T> query;

    @Setter
    private TypedQuery<Long> counter;

    public PagingTypedQueryImpl()
    {}

    public PagingTypedQueryImpl(TypedQuery<T> query, TypedQuery<Long> counter, Class<T> type)
    {
        this.query = query;
        this.counter = counter;
        setType(type);
    }

    @Override
    public long getItemCount()
    {
        return counter.getSingleResult();
    }

    @Override
    public List<T> getItems()
    {
        return query.setFirstResult(getFirstResultIndex()).getResultList();
    }


}
