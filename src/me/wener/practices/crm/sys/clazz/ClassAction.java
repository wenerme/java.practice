package me.wener.practices.crm.sys.clazz;


import javax.inject.Inject;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.crm.sys.clazz.service.ClassService;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.crm.sys.department.service.DepartmentService;
import me.wener.practices.web.common.action.ListDominateAction;

public class ClassAction extends ListDominateAction<ClassService, ClassEntity>
{
    @Inject
    @Override
    public void setService(ClassService service)
    {
        super.setService(service);
    }

    @Inject
    @Override
    public void setModel(ClassEntity model)
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
    public String add() throws Exception
    {
        valueStack("lessonList",service().getLessonList());
        return super.add();
    }

    @Override
    public String edit() throws Exception
    {
        valueStack("lessonList",service().getLessonList());
        return super.edit();
    }
}
