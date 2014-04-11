package me.wener.lesson.practice.crm.sys.common.dao;

public abstract class GeneralService<T, C extends ISearchCondition> implements IGeneralService<T, C>
{
    protected abstract IBaseDao<T> getDao();

    @Override
    public Paging<T> all() throws Exception
    {
        return getDao().selectPage();
    }

    @Override
    public void delete(int id) throws Exception
    {
        getDao().deleteById(id);
    }

    @Override
    public T add(T item) throws Exception
    {
        getDao().insert(item);
        return item;
    }

    @Override
    public T update(T item) throws Exception
    {
        getDao().update(item);
        return item;
    }

    @Override
    public boolean exists(int id) throws Exception
    {
        getDao().exists(id);
        return false;
    }

    @Override
    public boolean exists(T item) throws Exception
    {
        return getDao().exists(item);
    }

    @Override
    public T id(int id) throws Exception
    {
        return getDao().selectById(id);
    }
}
