package me.wener.practices.crm.sys.lesson.dao;


import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.crm.sys.lesson.entity.LessonSearcher;
import me.wener.practices.web.common.dao.BaseDao;
import me.wener.practices.web.common.dao.Paging;

public interface LessonDao extends BaseDao<LessonEntity, Long>
{
    Paging<LessonEntity> searchToPage(LessonSearcher searcher);
}
