package me.wener.practices.crm.sys.lesson;

import me.wener.practices.crm.sys.lesson.dao.LessonDao;
import me.wener.practices.crm.sys.lesson.dao.LessonDaoImpl;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.crm.sys.lesson.entity.LessonSearcher;
import me.wener.practices.crm.sys.lesson.service.LessonService;
import me.wener.practices.crm.sys.lesson.service.LessonServiceImpl;
import me.wener.practices.web.common.annotation.NonSingleton;
import me.wener.practices.web.common.util.AbstractModuleConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configurable
public class LessonModuleConfiguration extends AbstractModuleConfiguration
{
    @Bean
    @NonSingleton
    public LessonEntity lessonEntity(){return newEntity(LessonEntity.class);}
//    @Bean
//    @NonSingleton
//    public LessonSearcher lessonSearcher(){return newEntity(LessonSearcher.class);}
    @Bean
    public LessonService lessonService(){return newInstance(LessonServiceImpl.class);}
    @Bean
    public LessonDao lessonDao(){return newInstance(LessonDaoImpl.class);}
}
