package me.wener.practices.crm.sys.clazz.service;


import java.util.List;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.web.common.dao.BaseDao;
import me.wener.practices.web.common.service.BaseService;

public interface ClassService extends BaseService<ClassEntity, Long>
{
    ClassEntity editTo(ClassEntity model);

    List<LessonEntity> getLessonList();
}
