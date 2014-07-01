package me.wener.learn.jk.mapper;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T, ID extends Serializable>
{
    int delete(T entity);
    int deleteById(ID id);
    int deleteByIds(List<ID> ids);
    List<T> findAll();
    T findById(ID id);
    List<T> findByIds(List<ID> ids);
    long count();
}
