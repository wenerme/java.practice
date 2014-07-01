package me.wener.practices.web.common.dao;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.googlecode.genericdao.search.ExampleOptions;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;


public interface BaseDao<T, ID extends Serializable> extends GenericDAO<T, ID>
{
    Paging<T> page();

    List<T> example(T t, ExampleOptions options);

    int exampleCount(T t, ExampleOptions options);

    int exampleCount(T t);

    List<T> example(T t);

    T exampleUnique(T t, ExampleOptions options);

    T exampleUnique(T t);

    Class<T> getType();

    /**
     * 获取该实体的 ID
     */
    ID idOf(T entity);
    /**
     * 返回结果列表
     */
    <E> List<E> all(CriteriaQuery<E> query);
    /**
     * 查询单个值
     */
    <E> E one(CriteriaQuery<E> query);
}
