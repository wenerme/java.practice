package me.wener.lesson.practice.crm.sys.common.dao;

import com.google.common.base.Joiner;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import lombok.Getter;
import lombok.ToString;
import me.wener.lesson.practice.crm.sys.admin.dao.impl.AdminDao;
import me.wener.lesson.practice.crm.sys.admin.entity.Admin;
import me.wener.lesson.practice.crm.sys.group.entity.Group;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@ToString
public class Paging<T>
        implements Iterator<List<T>>, Serializable
{
    public static final int DEFAULT_COUNT_PRE_PAGE = 10;
    @Getter
    private long prePageCount = DEFAULT_COUNT_PRE_PAGE;
    @Getter
    private final long itemCount;

    QueryBuilder<T, Integer> builder = null;
    Dao<T, Integer> dao;
    /**
     * 在内部 该值范围为 [0-) 对于 getter 和 setter 来说 范围为 [1-)
     */
    private long currentPageNo = 0;


    public Paging(Dao<T, Integer> dao, QueryBuilder<T, Integer> builder)
            throws SQLException
    {

        checkNotNull(builder, "builder 不能为空");
        checkNotNull(dao, "dao 不能为空");

        this.dao = dao;
        this.builder = builder;
        itemCount = dao.countOf(builder.setCountOf(true).prepare());

    }

    public Paging(Dao<T, Integer> dao) throws SQLException
    {

        checkNotNull(dao, "dao 不能为空");

        this.dao = dao;
        itemCount = dao.countOf();
    }

    public static void main(String[] args) throws SQLException
    {
        Paging<Admin> page = new AdminDao().selectPage(1, 1);

        System.out.println("hasNext ?" + page.hasNext());
        System.out.println("hasPrevious ?" + page.hasPrevious());
        System.out.println("getPageCount: " + page.getPageCount());

        System.out.println("Type is :" + page.getItems().get(0).getClass());

        System.out.println(page);
        Iterator<Group> itor;
        ListIterator<String> itro2;
        // System.out.println("All items: \n"+page.dao.queryForAll());
        while (page.hasNext())
        {
            System.out.printf("\nPageNO: %d", page.getCurrentPageNo());
            List<Admin> list = page.next();
            System.out.printf(" Items:\n %s", Joiner.on("\n").join(list));
        }

        System.out.printf("\nFinished hasNext, NO is : %d\n", page.getCurrentPageNo());
        System.out.println(page.getItems());

        page.setCurrentPageNo(2);
        System.out.println(page);
        System.out.println("previous:");
        while (page.hasPrevious())
        {
            System.out.printf("\nPageNO: %d", page.getCurrentPageNo());
            List<Admin> list = page.previous();
            System.out.printf(" Items:\n %s", Joiner.on("\n").join(list));
        }

        System.out.printf("\nFinished hasPrevious, NO is : %d\n", page.getCurrentPageNo());
        System.out.println(page.getItems());

        System.out.println("\n\nWith builder");
        QueryBuilder<Admin, Integer> qb = page.dao.queryBuilder();

        qb.where().eq("username", "wener");
        page = page.with(qb);

        System.out.println(page);
        while (page.hasNext())
        {
            System.out.printf("\nPageNO: %d", page.getCurrentPageNo());
            List<Admin> list = page.next();
            System.out.printf(" Items:\n %s", Joiner.on("\n").join(list));
        }
    }

    public Paging<T> with(QueryBuilder<T, Integer> builder) throws SQLException
    {
        return new Paging<>(dao, builder)
                .setPrePageCount(getPrePageCount());
    }

    /**
     * 设置每页的数量
     */
    public Paging<T> setPrePageCount(long prePage)
    {
        checkArgument(prePage > 0, "每页数不能比 1 小");
        prePageCount = prePage;
        return this;
    }

    public long getCurrentPageNo()
    {
        return currentPageNo + 1;
    }

    /**
     * 设置页号
     */
    public Paging<T> setCurrentPageNo(long pageNo)
    {
        checkArgument(pageNo > 0, "页号不能比 1 小");
        currentPageNo = pageNo - 1;
        return this;
    }

    /**
     * 获取表项的类型
     */
    public Class<T> getType()
    {
        return dao.getDataClass();
    }

    /**
     * 获取页面总数
     */
    public long getPageCount()
    {
        return (long) Math
                .ceil((double) getItemCount() / (double) prePageCount);
    }

    /**
     * 判断是否还有上一页
     */
    public boolean hasPrevious()
    {
        return currentPageNo > 0;
    }

    public List<T> previous()
    {
        List<T> list;
        if (!hasPrevious())
            throw new NoSuchElementException();

        try
        {
            list = getItems();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("获取项时产生异常", e);
        }

        currentPageNo--;
        return list;
    }

    public void nextPage()
    {
        if (hasNext())
        {
            currentPageNo++;
        }
    }

    public void lastPage()
    {
        if (hasPrevious())
        {
            currentPageNo--;
        }
    }

    public long getNextPageNo()
    {

        return hasNext() ? getCurrentPageNo() + 1 : getCurrentPageNo();

    }

    public long getPreviousPageNo()
    {

        return hasPrevious() ? getCurrentPageNo() - 1 : getCurrentPageNo();

    }

    /**
     * 获取项目列表
     * 若 hasNext 或 hasPrevious 为 false 时 会返回 1 或最后一页
     *
     * @return
     * @throws SQLException
     */
    public List<T> getItems() throws SQLException
    {
        long offset = getPageCount();
        offset = currentPageNo >= offset ? offset : currentPageNo;
        offset = currentPageNo < 0 ? 0 : currentPageNo;
        offset = offset * prePageCount;

        if (builder == null)
        {
            return dao.queryBuilder().offset(offset)
                    .limit(prePageCount).query();
        }
        builder.setCountOf(false).offset(offset).limit(prePageCount);
        return dao.query(builder.prepare());
    }

    @Override
    public boolean hasNext()
    {
        return currentPageNo < getPageCount()-1;// 因为 currentPageNo 内部表示为 [0-)
    }

    @Override
    public List<T> next()
    {
        List<T> list;
        if (!hasNext())
            throw new NoSuchElementException();

        try
        {
            list = getItems();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("获取项时产生异常", e);
        }

        currentPageNo++;
        return list;
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}

