package me.wener.practices.crm.sys.student.school;

import me.wener.practices.crm.sys.student.school.dao.StudentDao;
import me.wener.practices.crm.sys.student.school.dao.StudentDaoImpl;
import me.wener.practices.crm.sys.student.school.entity.StudentEntity;
import me.wener.practices.crm.sys.student.school.service.StudentService;
import me.wener.practices.crm.sys.student.school.service.StudentServiceImpl;
import me.wener.practices.web.common.annotation.NonSingleton;
import me.wener.practices.web.common.util.AbstractModuleConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class StudentModuleConfiguration extends AbstractModuleConfiguration
{
    @Bean
    @NonSingleton
    public StudentEntity studentEntity(){return newEntity(StudentEntity.class);}
    @Bean
    public StudentService studentService(){return newInstance(StudentServiceImpl.class);}
    @Bean
    public StudentDao studentDao(){return newInstance(StudentDaoImpl.class);}
}
