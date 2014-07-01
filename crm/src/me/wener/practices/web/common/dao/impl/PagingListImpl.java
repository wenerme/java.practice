package me.wener.practices.web.common.dao.impl;


import com.google.common.collect.Lists;
import java.util.List;
import me.wener.practices.web.common.dao.AbstractPaging;

/**
 * 包装 List 对象实现的分页
 *
 * @param <T> 实体类型
 */
public class PagingListImpl<T> extends AbstractPaging<T>
{
    private List<T> list;

    public PagingListImpl(){}
    public PagingListImpl(List<T> list)
    {
        this.list = list;
    }

    @Override
    public long getItemCount()
    {
        return list.size();
    }

    @Override
    public List<T> getItems()
    {
        List<T> items = Lists.newArrayList();
        int min = getFirstResultIndex();
        int max = min + getPageSize();
        for (int i = min; i < list.size() && i < max; i++)
            items.add(list.get(i));

        return items;
    }
}
