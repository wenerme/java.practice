package me.wener.lesson.practice.crm.sys.common;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDao<T>
{

    public abstract List<T> selectAll() throws SQLException;

    public abstract T selectById(int id) throws SQLException;

    public int insert(T t) throws SQLException;

    public int delete(T t) throws SQLException;

    public int update(T t) throws SQLException;

    public long count() throws SQLException;

    int refresh(T t) throws SQLException;

    Paging<T> selectPage(long pageNo, int prePage) throws SQLException;

    Paging<T> selectPage() throws SQLException;

    int deleteById(int id) throws SQLException;

    Paging<T> selectPageById(int id) throws SQLException;
}
