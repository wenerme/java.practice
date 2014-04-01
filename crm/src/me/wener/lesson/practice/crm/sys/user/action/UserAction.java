package me.wener.lesson.practice.crm.sys.user.action;


import lombok.Getter;
import lombok.Setter;
import me.wener.lesson.practice.crm.sys.common.action.GeneralAction;
import me.wener.lesson.practice.crm.sys.user.entity.User;
import me.wener.lesson.practice.crm.sys.user.service.impl.UserService;

import java.text.DateFormat;
import java.util.Date;

public class UserAction extends GeneralAction<User>
{
    public static void main(String[] args)
    {
        System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));
    }


    public String disable() throws Exception
    {
        UserService service = getService();

        for (String id : getIds())
            service.disable(Integer.parseInt(id));

        return this.SUCCESS;
    }

    public String enable() throws Exception
    {
        UserService service = getService();

        for (String id : getIds())
            service.enable(Integer.parseInt(id));

        return this.SUCCESS;
    }


    public String report(String msg)
    {
        return null;
    }

    public String error(String msg)
    {
        return null;
    }

    @Override
    protected UserService getService()
    {
        return new UserService();
    }

    @Override
    protected Class<User> getType()
    {
        return User.class;
    }


}


