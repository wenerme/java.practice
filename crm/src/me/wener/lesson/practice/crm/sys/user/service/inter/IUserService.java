package me.wener.lesson.practice.crm.sys.user.service.inter;

import me.wener.lesson.practice.crm.sys.common.Paging;
import me.wener.lesson.practice.crm.sys.common.web.IGeneralService;
import me.wener.lesson.practice.crm.sys.user.UserSearchCondition;
import me.wener.lesson.practice.crm.sys.user.entity.User;

import java.sql.SQLException;

public interface IUserService extends IGeneralService<User>
{
    Paging<User> searchByCondition(UserSearchCondition condition) throws SQLException;

    User add(User user) throws Exception;

    void disable(int id) throws Exception;

    void enable(int id) throws Exception;

    void delete(int id) throws Exception;
}
