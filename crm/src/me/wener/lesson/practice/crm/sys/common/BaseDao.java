package me.wener.lesson.practice.crm.sys.common;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> implements IBaseDao<T>
{
    static private final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/crm";
    Class<T> clazz;
    @Getter
    String tableName;
    @Getter(AccessLevel.PROTECTED)
    private Dao<T, Integer> dao;

    @SuppressWarnings("unchecked")// 实际类型参数转换问题
    @SneakyThrows
    public BaseDao()
    {
        ParameterizedType su = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) su.getActualTypeArguments()[0];

        tableName = clazz.getName().replaceFirst(".*\\.([^.]+)$", "$1") + "s";
        tableName = tableName.toLowerCase();

        // 这里的 SQLException 一般不会发生 所以作为运行时抛出了
        try
        {
            dao = DaoManager.createDao(new DataSourceConnectionSource(DBHelper.getDataSource(), JDBC_URL), clazz);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("创建 DAO 失败", e);
        }
    }

    public static void main(String[] args) throws Exception
    {
        BaseDao<String> dao = new BaseDao<String>()
        {

        };
        assert dao.tableName.equals("strings");

        System.out.println("Pass");
    }

    @Override
    public T selectById(int id) throws SQLException
    {
        return dao.queryForId(id);
    }

    @Override
    public List<T> selectAll() throws SQLException
    {
        return dao.queryForAll();
    }

    public List<T> select() throws SQLException
    {
        String sql = "select * from " + tableName;
        QueryRunner runner = new QueryRunner(DBHelper.getDataSource());

        return runner.query(sql, new BeanListHandler<T>(clazz));
    }

    @Override
    public int insert(T t) throws SQLException
    {

        return dao.create(t);
    }

    @Override
    public int delete(T t) throws SQLException
    {
        return dao.delete(t);
    }

    @Override
    public int deleteById(int id) throws SQLException
    {
        return dao.deleteById(id);
    }

    @Override
    public int update(T t) throws SQLException
    {
        return dao.update(t);
    }

    @Override
    public int refresh(T t) throws SQLException
    {

        return dao.refresh(t);
    }

    @Override
    public long count() throws SQLException
    {
        return dao.countOf();
    }

    @Override
    public Paging<T> selectPage(long pageNo, int prePage) throws SQLException
    {
        Paging<T> page = new Paging<T>(dao).setCurrentPageNo(pageNo).setPrePageCount(prePage);

        return page;
    }

    @Override
    public Paging<T> selectPage() throws SQLException
    {
        return selectPage(1, Paging.DEFAULT_COUNT_PRE_PAGE);
    }

    @Override
    public Paging<T> selectPageById(int id) throws SQLException
    {
        return selectPage(1, Paging.DEFAULT_COUNT_PRE_PAGE);
    }
}
