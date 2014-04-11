package me.wener.lesson.practice.crm.sys.user.service.impl;

import me.wener.lesson.practice.crm.sys.common.dao.GeneralService;
import me.wener.lesson.practice.crm.sys.common.dao.IBaseDao;
import me.wener.lesson.practice.crm.sys.common.dao.IGeneralService;
import me.wener.lesson.practice.crm.sys.common.dao.Paging;
import me.wener.lesson.practice.crm.sys.user.UserSearchCondition;
import me.wener.lesson.practice.crm.sys.user.dao.impl.UserDao;
import me.wener.lesson.practice.crm.sys.user.dao.inter.IUserDao;
import me.wener.lesson.practice.crm.sys.user.entity.User;
import me.wener.lesson.practice.crm.sys.user.service.inter.IUserService;

import java.sql.SQLException;

public class UserService extends GeneralService<User,UserSearchCondition> implements IUserService
{
    @Override
    protected IUserDao getDao()
    {
        return new UserDao();
    }

    @Override
    public Paging<User> search(UserSearchCondition condition) throws SQLException
    {
        return new UserDao().search(condition);
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

}
