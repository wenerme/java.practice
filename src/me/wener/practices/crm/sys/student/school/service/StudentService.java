package me.wener.practices.crm.sys.student.school.service;


import me.wener.practices.crm.sys.student.school.entity.StudentEntity;
import me.wener.practices.web.common.service.BaseService;

public interface StudentService extends BaseService<StudentEntity, Long>
{
    StudentEntity editTo(StudentEntity model);
}
