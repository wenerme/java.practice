package me.wener.practices.web.common.dao;


import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import java.io.Serializable;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import me.wener.practices.web.common.dao.impl.PagingCriteriaQueryImpl;
import me.wener.practices.web.common.dao.jpa.CriteriaUtils;

/**
 * 抽象的 Dao,虽然需要两个类型参数,但是这个类主要是实现和类型无关的操作.<br/>
 * 也就是说这个类里的方法不会涉及到 T 和 ID 类型参数
 */
public abstract class AbstractDao<T, ID extends Serializable> extends GenericDAOImpl<T, ID>
{

    public <E> List<E> all(CriteriaQuery<E> query)
    {
        return em().createQuery(query).getResultList();
    }

    public <E> E one(CriteriaQuery<E> query)
    {
        return em().createQuery(query).getSingleResult();
    }

    /**
     * 获取该查询对应的查询对象, 主要用于外部调用
     */
    public <E> TypedQuery<E> getQuery(CriteriaQuery<E> query)
    {
        return em().createQuery(query);
    }

    /**
     * 获取该查询对象对应的 获取总数查询对象
     */
    public CriteriaQuery<Long> getCountQuery(CriteriaQuery<?> query)
    {
        CriteriaBuilder cb = em().getCriteriaBuilder();
        CriteriaQuery<Long> counter = cb.createQuery(Long.class);
        counter.select(cb.count(counter.from(query.getResultType())));

        CriteriaUtils.copyRestriction(query, counter);
        return counter;
    }

    /**
     * 根据一个查询对象生成一个分页对象
     */
    protected <E> Paging<E> paging(CriteriaQuery<E> query)
    {
        return new PagingCriteriaQueryImpl<>(query, getCountQuery(query), this);
    }
}
