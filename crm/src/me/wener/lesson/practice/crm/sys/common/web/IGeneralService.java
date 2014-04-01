package me.wener.lesson.practice.crm.sys.common.web;

import me.wener.lesson.practice.crm.sys.common.dao.Paging;

public interface IGeneralService<T>
{
    Paging<T> findAll() throws Exception;
    void delete(int id) throws Exception;
    T add(T item) throws Exception;
}
