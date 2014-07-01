package me.wener.practices.crm.sys.student.school;

import javax.inject.Inject;
import me.wener.practices.crm.sys.student.school.entity.StudentEntity;
import me.wener.practices.crm.sys.student.school.service.StudentService;
import me.wener.practices.web.common.action.ListDominateAction;


public class StudentAction extends ListDominateAction<StudentService, StudentEntity>
{
    @Inject
    @Override
    public void setService(StudentService service)
    {
        super.setService(service);
    }

    @Inject
    @Override
    public void setModel(StudentEntity model)
    {
        super.setModel(model);
    }

    @Override
    protected String handleEdit()
    {
        service().editTo(model());
        return null;
    }
}
