package me.wener.practices.crm.sys.clazz.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.crm.sys.student.school.entity.StudentEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Accessors(chain = true)
@Data
@Entity
public class ClassEntity
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private LessonEntity lesson;
    private Date startDate;
    private Date endDate;
    private String state;
    private String remark;
    @OneToMany
    private Set<StudentEntity> students;
    @Version
    private int version;
}
