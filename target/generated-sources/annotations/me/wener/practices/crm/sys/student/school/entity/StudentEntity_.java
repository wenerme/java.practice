package me.wener.practices.crm.sys.student.school.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.web.common.entity.Sex;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StudentEntity.class)
public abstract class StudentEntity_ {

	public static volatile SingularAttribute<StudentEntity, Long> id;
	public static volatile SingularAttribute<StudentEntity, Sex> sex;
	public static volatile SingularAttribute<StudentEntity, String> phone;
	public static volatile SingularAttribute<StudentEntity, String> school;
	public static volatile SingularAttribute<StudentEntity, String> remark;
	public static volatile SingularAttribute<StudentEntity, String> address;
	public static volatile SingularAttribute<StudentEntity, String> QQ;
	public static volatile SingularAttribute<StudentEntity, Integer> age;
	public static volatile SingularAttribute<StudentEntity, String> name;
	public static volatile SingularAttribute<StudentEntity, String> education;
	public static volatile SingularAttribute<StudentEntity, ClassEntity> clazz;
	public static volatile SingularAttribute<StudentEntity, String> major;
	public static volatile SingularAttribute<StudentEntity, Integer> version;

}

