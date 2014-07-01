package me.wener.practices.crm.sys.employee;


import javax.inject.Named;
import javax.inject.Qualifier;
import me.wener.practices.web.common.util.AbstractModuleConfiguration;
import me.wener.practices.web.common.annotation.NonSingleton;
import me.wener.practices.crm.sys.employee.dao.UserDao;
import me.wener.practices.crm.sys.employee.dao.UserDaoImpl;
import me.wener.practices.crm.sys.employee.entity.UserEntity;
import me.wener.practices.crm.sys.employee.service.UserService;
import me.wener.practices.crm.sys.employee.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class UserModuleConfiguration extends AbstractModuleConfiguration
{
    @Bean
    public UserDao userDao()
    {
        return newInstance(UserDaoImpl.class);
    }

    @Bean
    public UserService userService()
    {
        return newInstance(UserServiceImpl.class);
    }

    @Bean
    @NonSingleton
    public UserEntity userEntity()
    {
        return newEntity(UserEntity.class);
    }
}
