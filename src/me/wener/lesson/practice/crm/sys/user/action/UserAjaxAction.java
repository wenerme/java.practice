package me.wener.lesson.practice.crm.sys.user.action;


import me.wener.lesson.practice.crm.sys.common.action.GeneralListAction;
import me.wener.lesson.practice.crm.sys.common.action.ajax.GeneralAjaxAction;
import me.wener.lesson.practice.crm.sys.common.action.ajax.GeneralListAjaxAction;
import me.wener.lesson.practice.crm.sys.common.dao.IGeneralService;
import me.wener.lesson.practice.crm.sys.user.UserSearchCondition;
import me.wener.lesson.practice.crm.sys.user.entity.User;
import me.wener.lesson.practice.crm.sys.user.service.impl.UserService;

public class UserAjaxAction extends GeneralListAjaxAction<User, UserSearchCondition>
{

    private UserService service;

    @Override
    protected IGeneralService<User, UserSearchCondition> getService()
    {
        return this.service == null ? this.service = new UserService(): this.service;
    }

}
