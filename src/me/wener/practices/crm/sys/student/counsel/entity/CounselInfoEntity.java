package me.wener.practices.crm.sys.student.counsel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import lombok.Data;
import lombok.experimental.Accessors;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.web.common.entity.Sex;

/* 咨询学生管理
姓名：		联系地址：		意向班级：
学校：		QQ：		电话：
年龄：		性别：		学历：
备注：	 	 	  */

/**
 * 咨询学生信息
 */
@Accessors(chain = true)
@Data
@Entity
public class CounselInfoEntity
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String school;
    private String QQ;
    private String phone;
    private Integer age;
    private Sex sex;
    /** 学历 */
    private String education;

    /** 班级意向 */
    @OneToOne
    private ClassEntity intentionClass;

    @Lob
    private String remark;

    @Version
    private Integer version;
}
