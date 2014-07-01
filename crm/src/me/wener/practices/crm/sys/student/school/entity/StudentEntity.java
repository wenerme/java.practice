package me.wener.practices.crm.sys.student.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import lombok.Data;
import lombok.experimental.Accessors;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.web.common.entity.Sex;

/**
 * 在校学生信息
 */
@Accessors(chain = true)
@Data
@Entity
public class StudentEntity
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private String QQ;
    private Sex sex;
    @ManyToOne
    private ClassEntity clazz;// 班级
    private String address;
    private String school;
    private Integer age;
    /** 主修 */
    private String remark;
    private String major;
    /**
     * 学历
     */
    private String education;
    @Version
    private Integer version;

}
