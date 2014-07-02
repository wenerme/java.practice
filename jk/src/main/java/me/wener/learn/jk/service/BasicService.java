package me.wener.learn.jk.service;

import java.io.Serializable;
import java.util.List;

public interface BasicService<T, ID extends Serializable>
{
    int delete(T entity);
    int deleteById(ID id);
    int deleteByIds(List<ID> ids);
    List<T> findAll();
    T findById(ID id);
    List<T> findByIds(List<ID> ids);
    long count();

    // 这两个方法不一定必须实现 :-)
    void insert(T entity);
    void update(T entity);
}
