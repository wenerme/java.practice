package me.wener.lesson.practice.crm.sys.admin.dao.impl;

import me.wener.lesson.practice.crm.sys.admin.dao.inter.IAdminDao;
import me.wener.lesson.practice.crm.sys.admin.entity.Admin;
import me.wener.lesson.practice.crm.sys.common.dao.BaseDao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class AdminDao extends BaseDao<Admin> implements IAdminDao
{

    @Override
    public Admin findByNameAndPassword(String username, String password) throws SQLException
    {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", password);
        List<Admin> list = getDao().queryForFieldValues(map);
        return list.size() > 0 ? list.get(0) : null;
    }

}
