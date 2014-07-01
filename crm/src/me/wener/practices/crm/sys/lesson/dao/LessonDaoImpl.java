package me.wener.practices.crm.sys.lesson.dao;


import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity_;
import me.wener.practices.crm.sys.lesson.entity.LessonSearcher;
import me.wener.practices.web.common.dao.BaseDaoImpl;
import me.wener.practices.web.common.dao.CriteriaQueryHelper;
import me.wener.practices.web.common.dao.LogicMode;
import me.wener.practices.web.common.dao.Paging;
import me.wener.practices.web.common.dao.WildcardWrapMode;
import me.wener.practices.web.common.util.BeanHelper;

public class LessonDaoImpl
        extends BaseDaoImpl<LessonEntity, Long>
        implements LessonDao
{
    public List<LessonEntity> searchAll(LessonEntity searcher)
    {
        CriteriaQueryHelper<LessonEntity> helper = getQueryHelper();

        CriteriaQuery<LessonEntity> query = helper.getQuery()
                .where(helper.like(searcher, LogicMode.AND, BeanHelper.skipNullOrEmpty(searcher, LessonEntity_.name, LessonEntity_.description)));

        return all(query);
    }

    @Override
    public Paging<LessonEntity> searchToPage(LessonSearcher searcher)
    {
        CriteriaQueryHelper<LessonEntity> helper = getQueryHelper();

        Predicate predicate = helper.like(searcher, LogicMode.AND, WildcardWrapMode.Both, LessonEntity_.name, LessonEntity_.description);

        helper.getQuery().where(predicate);

        return paging(helper.getQuery());
    }
}
