package me.wener.practices.web.common.service;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;
import lombok.Setter;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.web.common.dao.BaseDao;
import me.wener.practices.web.common.dao.Paging;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseServiceImpl<DAO extends BaseDao<T, ID>, T, ID extends Serializable>
        implements BaseService<T, ID>
{
    @Setter
    private DAO dao;

    protected DAO dao()
    {
        return dao;
    }

    @Transactional(readOnly = true)
    @Override
    public final T id(ID id)
    {
        return dao().find(id);
    }

    @Transactional(readOnly = true)
    @Override
    @SafeVarargs
    public final T[] id(ID... ids)
    {
        return dao().find(ids);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> all()
    {
        return dao().findAll();
    }

    protected boolean delete(T entity)
    {
        return dao().remove(entity);
    }

    protected void delete(List<T> entities)
    {
        dao().remove(asTArray(entities));
    }

    @Override
    public boolean delete(ID id)
    {
        T t = id(id);
        return t != null && delete(t);
    }

    @Override
    public void save(T model)
    {
        dao().save(model);
    }

    @SuppressWarnings("unchecked")
    protected T[] asTArray(List<T> list)
    {
        T[] array = (T[]) Array.newInstance(dao().getType(), 0);
        return list.toArray(array);
    }

    @Override
    public Paging<T> page()
    {
        return dao().page();
    }

    @Override
    public Paging<T> page(int page)
    {
        return dao().page().setCurrentPage(page);
    }

    @Override
    public Class<T> getType()
    {
        return dao().getType();
    }

}
