package me.wener.practices.crm.sys.department;


import me.wener.practices.crm.sys.department.dao.DepartmentDao;
import me.wener.practices.crm.sys.department.dao.DepartmentDaoImpl;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.crm.sys.department.service.DepartmentService;
import me.wener.practices.crm.sys.department.service.DepartmentServiceImpl;
import me.wener.practices.crm.sys.employee.dao.UserDao;
import me.wener.practices.crm.sys.employee.dao.UserDaoImpl;
import me.wener.practices.crm.sys.employee.entity.UserEntity;
import me.wener.practices.crm.sys.employee.service.UserService;
import me.wener.practices.crm.sys.employee.service.UserServiceImpl;
import me.wener.practices.web.common.annotation.NonSingleton;
import me.wener.practices.web.common.util.AbstractModuleConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class DepartmentModuleConfiguration extends AbstractModuleConfiguration
{
    @Bean
    public DepartmentDao departmentDao()
    {
        return newInstance(DepartmentDaoImpl.class);
    }

    @Bean
    public DepartmentService departmentService()
    {
        return newInstance(DepartmentServiceImpl.class);
    }

    @Bean
    @NonSingleton
    public DepartmentEntity departmentEntity()
    {
        return newEntity(DepartmentEntity.class);
    }
}
