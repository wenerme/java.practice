package me.wener.lesson.practice.crm.sys.common;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public final class DBHelper
{
    private DBHelper()
    {
    }

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static DataSource getDataSource()
    {
        return dataSource;
    }
}
