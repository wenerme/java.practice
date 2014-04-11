package me.wener.lesson.practice.crm.sys.common.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public interface IPaging<T> extends Iterator<List<T>>
{
    final static int DEFAULT_COUNT_PRE_PAGE = 10;

    long getCurrentPageNo();

    long getPageCount();

    List<T> getItems() throws SQLException;

    @Override
    boolean hasNext();

    @Override
    List<T> next();
}
