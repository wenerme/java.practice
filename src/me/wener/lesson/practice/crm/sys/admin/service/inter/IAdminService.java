package me.wener.lesson.practice.crm.sys.admin.service.inter;

import me.wener.lesson.practice.crm.sys.admin.entity.Admin;

public interface IAdminService
{
    public Admin login(String username, String password) throws Exception;
}
