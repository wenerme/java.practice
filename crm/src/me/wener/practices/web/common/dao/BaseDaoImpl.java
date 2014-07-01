package me.wener.practices.web.common.dao;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import me.wener.practices.web.common.dao.impl.PagingSearchImpl;

public class BaseDaoImpl<T, ID extends Serializable>
        extends AbstractDao<T, ID>
        implements BaseDao<T, ID>
{
    @Override
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager)
    {
        super.setEntityManager(entityManager);
    }

    @Override
    @Inject
    public void setSearchProcessor(JPASearchProcessor searchProcessor)
    {
        super.setSearchProcessor(searchProcessor);
    }

    @Override
    public Paging<T> page()
    {
        return paging(new Search());
    }

    /**
     * 根据一个 Search 对象返回一个分页对象
     */
    protected Paging<T> paging(Search search)
    {
        search.setSearchClass(persistentClass);
        return new PagingSearchImpl<T>(this, search);
    }

    @Override
    public List<T> example(T t, ExampleOptions options)
    {
        Search search = new Search();
        search.addFilter(getFilterFromExample(t, options));
        return search(search);
    }

    @Override
    public int exampleCount(T t, ExampleOptions options)
    {
        Search search = new Search();
        search.addFilter(getFilterFromExample(t, options));
        return searchAndCount(search).getTotalCount();
    }

    @Override
    public int exampleCount(T t)
    {
        return exampleCount(t, null);
    }

    @Override
    public List<T> example(T t)
    {
        return example(t, null);
    }

    @Override
    public T exampleUnique(T t, ExampleOptions options)
    {
        Search search = new Search();
        search.addFilter(getFilterFromExample(t, options));
        return searchUnique(search);
    }

    @Override
    public T exampleUnique(T t)
    {
        return exampleUnique(t, null);
    }

    @Override
    public Class<T> getType()
    {
        return persistentClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ID idOf(T entity)
    {
        return (ID) em().getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
    }

    protected CriteriaQueryHelper<T> getQueryHelper()
    {
        return CriteriaQueryHelper.create(em().getCriteriaBuilder(), persistentClass);
    }

}
