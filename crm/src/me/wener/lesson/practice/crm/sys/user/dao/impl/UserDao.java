package me.wener.lesson.practice.crm.sys.user.dao.impl;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;
import me.wener.lesson.practice.crm.sys.common.dao.BaseDao;
import me.wener.lesson.practice.crm.sys.common.Encryptor;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.user.UserSearchCondition;
import me.wener.lesson.practice.crm.sys.user.dao.inter.IUserDao;
import me.wener.lesson.practice.crm.sys.user.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.SQLException;
import java.util.Date;

public class UserDao extends BaseDao<User>
        implements IUserDao
{
    public static void main(String[] args) throws Exception
    {
        Log log = LogFactory.getLog(UserDao.class);
        log.info("Test start");

        UserDao dao = new UserDao();
        // 创建数据库
        TableUtils.createTableIfNotExists(dao.getDao().getConnectionSource(),
                User.class);
        Date end = new Date();
        end.setMonth(1);

        User u = new User();
        u.setEnname("wener");
        u.setCnname("文儿");
        u.setBeginDate(new Date());
        u.setEndDate(end);
        u.setEmail("wener.me@qq.com");
        u.setPassword(Encryptor.password("1234"));
        u.setId(1);

        dao.getDao().createIfNotExists(u);

        Paging<User> page = dao.selectPage();
        System.out.println("Page:" + page);
        System.out.println("Users:\n" + Joiner.on("\n").join(page.getItems()));


        UserSearchCondition condition = new UserSearchCondition();
        page = dao.search(condition);
        System.out.println("No condition Users:\n" + Joiner.on("\n").join(page.getItems()));
        condition.setCnname("文");
        page = dao.search(condition);
        System.out.println("With condition Users:\n" + Joiner.on("\n").join(page.getItems()));

    }

    @Override
    public Paging<User> search(UserSearchCondition condition) throws SQLException
    {

        // 如果有一个值为非空 才使用 where
        if (condition.getCnname() != null || condition.getEnname() != null || condition.getEnabled() != null || condition.getGroupId() != null)
        {
            QueryBuilder<User, Integer> qb = getDao().queryBuilder();
            Where<User, Integer> where = qb.where();

            if (!Strings.isNullOrEmpty(condition.getCnname()))
                where.like(User.FIELD_CNNAME, like(condition.getCnname())).and();

            if (!Strings.isNullOrEmpty(condition.getEnname()))
                where.like(User.FIELD_ENNAME, like(condition.getEnname())).and();

            if (condition.getEnabled() != null)
                where.like(User.FIELD_ENABLED, condition.getEnabled()).and();

            if (!Strings.isNullOrEmpty(condition.getGroupId()))
                where.like(User.FIELD_GROUP, condition.getGroupId()).and();

            where.raw("1 = 1");// 补足 and

            return new Paging<>(getDao(), qb);
        }

        return selectPage();
    }

    private static String like(String raw)
    {
        return "%" + raw + "%";
    }
}
