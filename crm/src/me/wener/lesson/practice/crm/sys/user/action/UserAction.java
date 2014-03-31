package me.wener.lesson.practice.crm.sys.user.action;


import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
    public String list()
    {
        System.out.println("yes in list");
        return this.SUCCESS;
    }

    public String add()
    {
        System.out.println("yes in add");
        return this.SUCCESS;
    }
}
