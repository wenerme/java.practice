package me.wener.lesson.practice.crm.sys.admin.dao.inter;

import me.wener.lesson.practice.crm.sys.admin.entity.Admin;
import me.wener.lesson.practice.crm.sys.common.dao.IBaseDao;

import java.sql.SQLException;

public interface IAdminDao extends IBaseDao<Admin>
{
    /**
     * 如果查询失败,会返回 {@code null}
     */
    Admin findByNameAndPassword(String userName, String password) throws SQLException;
}
