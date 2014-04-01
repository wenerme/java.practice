package me.wener.lesson.practice.crm.sys.user.action;


import me.wener.lesson.practice.crm.sys.common.action.GeneralAction;
import me.wener.lesson.practice.crm.sys.user.entity.User;
import me.wener.lesson.practice.crm.sys.user.service.impl.UserService;

public class UserAction extends GeneralAction<User>
{
    /**
     * 禁用操作
     */
    public String disable() throws Exception
    {
        UserService service = getService();

        for (String id : getIds())
            service.disable(Integer.parseInt(id));

        return this.SUCCESS;
    }

    /**
     * 启用操作
     */
    public String enable() throws Exception
    {
        UserService service = getService();

        for (String id : getIds())
            service.enable(Integer.parseInt(id));

        return this.SUCCESS;
    }

    @Override
    protected UserService getService()
    {
        return new UserService();
    }
}


