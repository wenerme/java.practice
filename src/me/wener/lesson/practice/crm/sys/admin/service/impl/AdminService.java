package me.wener.lesson.practice.crm.sys.admin.service.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;
import me.wener.lesson.practice.crm.sys.admin.dao.impl.AdminDao;
import me.wener.lesson.practice.crm.sys.admin.entity.Admin;
import me.wener.lesson.practice.crm.sys.admin.service.inter.IAdminService;
import me.wener.lesson.practice.crm.sys.common.DBHelper;
import me.wener.lesson.practice.crm.sys.common.Encryptor;

public class AdminService
        implements IAdminService
{

    public static void main(String[] args) throws Exception
    {
        AdminService ser = new AdminService();
        System.out.println("try login: "
                + ser.login("wener", "123456"));
        System.out.println("try login: "
                + ser.login("文儿", "123456"));
        System.out.println("try login: "
                + ser.login("文儿", "123456"));

        System.out.println(new AdminDao().selectAll());

        String url = "jdbc:mysql://127.0.0.1:3306/crm?user=root&password=root&useUnicode=true&characterEncoding=utf-8";
        // new DataSourceConnectionSource(DBHelper.getDataSource(),url)
        Dao<Admin, Integer> dao = DaoManager.createDao(
                new DataSourceConnectionSource(DBHelper.getDataSource(), url), Admin.class);

        Admin a = new Admin();
        a.setPassword(Encryptor.password("111111"));
        a.setUsername("笑笑");

        //dao.create(a);
        System.out.println(dao.queryForEq("username", "小文"));
        System.out.println(dao.queryForAll());
        // DaoManager.createDao(connectionSource, clazz)

    }

    @Override
    public Admin login(String username, String password) throws Exception
    {
        return new AdminDao().findByNameAndPassword(username, Encryptor.password(password));
    }

}
