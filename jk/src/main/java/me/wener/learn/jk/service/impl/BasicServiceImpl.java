package me.wener.learn.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import me.wener.learn.jk.mapper.BaseMapper;
import me.wener.learn.jk.service.BasicService;

public class BasicServiceImpl<T, ID extends Serializable, D extends BaseMapper<T,ID>> implements BasicService<T, ID>
{
    @Inject
    private D mapper;
    protected D mapper(){return mapper;}

    @Override
    public int delete(T entity)
    {
        return mapper.delete(entity);
    }

    @Override
    public int deleteById(ID id)
    {
        return mapper.deleteById(id);
    }

    @Override
    public int deleteByIds(List<ID> ids)
    {
        return mapper.deleteByIds(ids);
    }

    @Override
    public List<T> findAll()
    {
        return mapper.findAll();
    }

    @Override
    public T findById(ID id)
    {
        return mapper.findById(id);
    }

    @Override
    public List<T> findByIds(List<ID> ids)
    {
        return mapper.findByIds(ids);
    }

    @Override
    public long count()
    {
        return mapper.count();
    }

    @Override
    public void insert(T entity)
    {
        mapper.insert(entity);
    }

    @Override
    public void update(T entity)
    {
        mapper.update(entity);
    }
}
