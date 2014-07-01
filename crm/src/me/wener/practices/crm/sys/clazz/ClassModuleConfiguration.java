package me.wener.practices.crm.sys.clazz;


import me.wener.practices.crm.sys.clazz.dao.ClassDao;
import me.wener.practices.crm.sys.clazz.dao.ClassDaoImpl;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.crm.sys.clazz.service.ClassService;
import me.wener.practices.crm.sys.clazz.service.ClassServiceImpl;
import me.wener.practices.crm.sys.department.dao.DepartmentDao;
import me.wener.practices.crm.sys.department.dao.DepartmentDaoImpl;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.crm.sys.department.service.DepartmentService;
import me.wener.practices.crm.sys.department.service.DepartmentServiceImpl;
import me.wener.practices.web.common.annotation.NonSingleton;
import me.wener.practices.web.common.util.AbstractModuleConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class ClassModuleConfiguration extends AbstractModuleConfiguration
{
    @Bean
    public ClassDao classDao()
    {
        return newInstance(ClassDaoImpl.class);
    }

    @Bean
    public ClassService classService()
    {
        return newInstance(ClassServiceImpl.class);
    }

    @Bean
    @NonSingleton
    public ClassEntity classEntity()
    {
        return newEntity(ClassEntity.class);
    }
}
