package me.wener.practices.crm.sys.employee.service;


import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.web.common.service.BaseService;
import me.wener.practices.crm.sys.employee.entity.UserEntity;

import java.util.List;

public interface UserService extends BaseService<UserEntity, Long>
{
    UserEntity login(String account, String password);

    boolean isAccountExists(String account);

    UserEntity register(UserEntity user);

    List<DepartmentEntity> departments();

    UserEntity editTo(UserEntity model);
}
