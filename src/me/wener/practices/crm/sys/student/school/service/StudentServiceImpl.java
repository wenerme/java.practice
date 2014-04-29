package me.wener.practices.crm.sys.student.school.service;

import com.google.common.base.Strings;
import javax.inject.Inject;
import me.wener.practices.crm.sys.clazz.service.ClassService;
import me.wener.practices.crm.sys.student.school.dao.StudentDao;
import me.wener.practices.crm.sys.student.school.entity.StudentEntity;
import me.wener.practices.web.common.service.BaseServiceImpl;


public class StudentServiceImpl
    extends BaseServiceImpl<StudentDao, StudentEntity, Long>
        implements StudentService
{
    @Inject
    ClassService classService;
    @Inject
    @Override
    public void setDao(StudentDao dao)
    {super.setDao(dao);}

    @Override
    public StudentEntity editTo(StudentEntity model)
    {
        StudentEntity entity = id(model.getId());

        if (!Strings.isNullOrEmpty(model.getName()))
            entity.setName(model.getName());

        if (!Strings.isNullOrEmpty(model.getAddress()))
            entity.setAddress(model.getAddress());

        if (!Strings.isNullOrEmpty(model.getEducation()))
            entity.setEducation(model.getEducation());

        if (!Strings.isNullOrEmpty(model.getMajor()))
            entity.setMajor(model.getMajor());

        if (!Strings.isNullOrEmpty(model.getPhone()))
            entity.setPhone(model.getPhone());

        if (!Strings.isNullOrEmpty(model.getQQ()))
            entity.setQQ(model.getQQ());

        if (!Strings.isNullOrEmpty(model.getRemark()))
            entity.setPhone(model.getPhone());

        if (!Strings.isNullOrEmpty(model.getSchool()))
            entity.setSchool(model.getSchool());

        if (model.getAge() != null)
            entity.setAge(model.getAge());

        if (model.getSex() != null)
            entity.setSex(model.getSex());

        if (model.getClazz() != null)
        {
            entity.setClazz(classService.id(model.getClazz().getId()));
        }

        return entity;
    }
}
