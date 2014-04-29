package me.wener.practices.crm.sys.lesson.service;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.metamodel.Attribute;
import me.wener.practices.crm.sys.department.dao.DepartmentDao;
import me.wener.practices.crm.sys.lesson.dao.LessonDao;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity_;
import me.wener.practices.crm.sys.lesson.entity.LessonSearcher;
import me.wener.practices.crm.sys.student.counsel.entity.CounselInfoEntity;
import me.wener.practices.crm.sys.student.counsel.entity.CounselInfoEntity_;
import me.wener.practices.web.common.dao.Paging;
import me.wener.practices.web.common.service.BaseService;
import me.wener.practices.web.common.service.BaseServiceImpl;
import me.wener.practices.web.common.util.BeanHelper;


public class LessonServiceImpl
    extends BaseServiceImpl<LessonDao, LessonEntity, Long>
        implements LessonService
{
    @Inject
    @Override
    public void setDao(LessonDao dao)
    {super.setDao(dao);}

    @Override
    public LessonEntity editTo(LessonEntity model)
    {
        LessonEntity entity = id(model.getId());

//        if (!Strings.isNullOrEmpty(model.getName()))
//            entity.setName(model.getName());
//        if (!Strings.isNullOrEmpty(model.getDescription()))
//            entity.setDescription(model.getDescription());
//        if (null != model.getCost())
//            entity.setCost(model.getCost());
//        if (null != model.getPeriod())
//            entity.setPeriod(model.getPeriod());

        List<? extends Attribute<LessonEntity, ?>> editAttrs =
                Lists.<Attribute<LessonEntity, ?>>newArrayList(
                        LessonEntity_.name,
                        LessonEntity_.description,
                        LessonEntity_.cost,
                        LessonEntity_.period);

        // 这里是没有问题的,但是 IntelliJ 会在这里报错.
        BeanHelper.merge(entity, model, BeanHelper.skipNullOrEmpty(model, editAttrs));

        return entity;
    }

    public Paging<LessonEntity> searchToPage(LessonSearcher searcher)
    {
        return dao().searchToPage(searcher);
    }
}
