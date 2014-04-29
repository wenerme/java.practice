package me.wener.practices.crm.sys.lesson;

import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.crm.sys.department.service.DepartmentService;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.crm.sys.lesson.entity.LessonSearcher;
import me.wener.practices.crm.sys.lesson.service.LessonService;
import me.wener.practices.web.common.action.ListDominateAction;
import me.wener.practices.web.common.action.SearchableListDominateAction;
import me.wener.practices.web.common.entity.ISearcher;


public class LessonAction extends SearchableListDominateAction<LessonService, LessonEntity>
{
    @Getter
    LessonSearcher searcher = new LessonSearcher();

    @Inject
    @Override
    public void setService(LessonService service)
    {
        super.setService(service);
    }

    @Inject
    @Override
    public void setModel(LessonEntity model)
    {
        super.setModel(model);
    }

    @Override
    protected String handleEdit()
    {
        service().editTo(model());
        return null;
    }

    @Override
    protected String handlerSearch()
    {
        return null;
    }
}
