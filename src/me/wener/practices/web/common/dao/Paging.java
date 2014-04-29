package me.wener.practices.web.common.dao;

import java.util.Iterator;
import java.util.List;


public interface Paging<T>
{
    public static final int DEFAULT_PAGE_SIZE = 20;

    long getItemCount();

    /**
     * 获取总的页面编号,基于 1
     */
    int getPageCount();

    /**
     * 设置当前页号 基于0
     */
    Paging<T> setCurrentPage(int currentPage);

    /**
     * 基于 0 的页面编号
     */
    int getCurrentPage();

    /**
     * 基于 1 的页面编号
     */
    int getCurrentPageCount();

    List<T> getItems();

    Paging<T> setPageSize(int pageSize);

    int getPageSize();

    Class<T> getType();
}
