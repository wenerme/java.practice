package me.wener.lesson.practice.crm.sys.user.dao.inter;

import me.wener.lesson.practice.crm.sys.common.IBaseDao;
import me.wener.lesson.practice.crm.sys.common.Paging;
import me.wener.lesson.practice.crm.sys.user.UserSearchCondition;
import me.wener.lesson.practice.crm.sys.user.entity.User;

import java.sql.SQLException;

public interface IUserDao extends IBaseDao<User>
{

    public Paging<User> searchByCondition(UserSearchCondition condition) throws SQLException;
}
