package me.wener.practices.web.common.service;

import me.wener.practices.web.common.dao.Paging;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable>
{
    T id(ID id);

    @Transactional(readOnly = true)
    T[] id(ID... ids);

    List<T> all();

    boolean delete(ID id);

    Paging<T> page();

    Paging<T> page(int page);

    Class<T> getType();

    void save(T model);
}
