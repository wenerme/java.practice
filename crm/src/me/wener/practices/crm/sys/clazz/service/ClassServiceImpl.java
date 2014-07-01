package me.wener.practices.crm.sys.clazz.service;

import com.google.common.base.Strings;
import java.util.List;
import javax.inject.Inject;
import me.wener.practices.crm.sys.clazz.dao.ClassDao;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.crm.sys.lesson.dao.LessonDao;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.crm.sys.lesson.service.LessonService;
import me.wener.practices.web.common.service.BaseService;
import me.wener.practices.web.common.service.BaseServiceImpl;

public class ClassServiceImpl extends BaseServiceImpl<ClassDao, ClassEntity, Long>
        implements ClassService
{
    @Inject
    LessonService lessonService;
    @Inject
    @Override
    public void setDao(ClassDao dao)
    {super.setDao(dao);}

    @Override
    public ClassEntity editTo(ClassEntity model)
    {
        ClassEntity entity = id(model.getId());
        if (!Strings.isNullOrEmpty(model.getName()))
            entity.setName(model.getName());
        if (!Strings.isNullOrEmpty(model.getState()))
            entity.setState(model.getState());
        if (null != model.getEndDate())
            entity.setEndDate(model.getEndDate());
        if (null != model.getStartDate())
            entity.setStartDate(model.getStartDate());
        if (null != model.getLesson())
        {
            entity.setLesson(lessonService.id(model.getId()));
        }
        return entity;
    }

    @Override
    public List<LessonEntity> getLessonList()
    {
        return lessonService.all();
    }

}
