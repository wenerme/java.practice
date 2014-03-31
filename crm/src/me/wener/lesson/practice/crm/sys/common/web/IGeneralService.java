package me.wener.lesson.practice.crm.sys.common.web;

import me.wener.lesson.practice.crm.sys.common.Paging;

public interface IGeneralService<T>
{
    Paging<T> findAll() throws Exception;
}
