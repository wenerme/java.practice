package me.wener.lesson.practice.crm.sys.user.service.impl;

import me.wener.lesson.practice.crm.sys.common.Paging;
import me.wener.lesson.practice.crm.sys.user.UserSearchCondition;
import me.wener.lesson.practice.crm.sys.user.dao.impl.UserDao;
import me.wener.lesson.practice.crm.sys.user.entity.User;
import me.wener.lesson.practice.crm.sys.user.service.inter.IUserService;

import java.sql.SQLException;

public class UserService implements IUserService
{

    public static void main(String[] args) throws Exception
    {
        UserService service = new UserService();
        Paging<User> page = service.findAll();
        System.out.println(page.getItems());
        int id = page.getItems().get(0).getId();
        service.disable(id);
        System.out.println(page.getItems());


    }

    @Override
    public Paging<User> findAll() throws SQLException
    {
        return new UserDao().selectPage();
    }

    @Override
    public Paging<User> searchByCondition(UserSearchCondition condition) throws SQLException
    {
        return new UserDao().searchByCondition(condition);
    }

    @Override
    public User add(User user) throws Exception
    {
        new UserDao().insert(user);
        return user;
    }

    @Override
    public void disable(int id) throws Exception
    {
        User user = new UserDao().selectById(id);
        user.setEnabled(false);
        new UserDao().update(user);
    }

    @Override
    public void enable(int id) throws Exception
    {
        User user = new UserDao().selectById(id);
        user.setEnabled(true);
        new UserDao().update(user);
    }

    @Override
    public void delete(int id) throws Exception
    {
        new UserDao().deleteById(id);
    }

}
