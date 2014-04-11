package me.wener.lesson.practice.crm.sys.user.service.inter;

import me.wener.lesson.practice.crm.sys.common.dao.IGeneralService;
import me.wener.lesson.practice.crm.sys.user.UserSearchCondition;
import me.wener.lesson.practice.crm.sys.user.entity.User;

public interface IUserService extends IGeneralService<User,UserSearchCondition>
{
    void disable(int id) throws Exception;

    void enable(int id) throws Exception;
}
