package me.wener.lesson.practice.crm.sys.common.dao;

import me.wener.lesson.practice.crm.sys.common.dao.ISearchCondition;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;

/**
 * 抽象的 通用服务逻辑
 * @param <T> 项目类型
 * @param <C> 搜索条件类型,必须继承自 ISearchCondition
 */
public interface IGeneralService<T,C extends ISearchCondition>
{
    Paging<T> all() throws Exception;
    void delete(int id) throws Exception;
    T add(T item) throws Exception;
    Paging<T> search(C condition) throws Exception;
}
