package me.wener.practices.crm.sys.employee.dao;


import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.web.common.dao.BaseDao;
import me.wener.practices.crm.sys.employee.entity.UserEntity;

import java.util.List;

public interface UserDao extends BaseDao<UserEntity, Long>
{
    List<DepartmentEntity> departments();
}
