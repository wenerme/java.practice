package me.wener.practices.crm.sys.lesson.service;


import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.web.common.service.BaseService;

public interface LessonService extends BaseService<LessonEntity, Long>
{
    LessonEntity editTo(LessonEntity model);
}
