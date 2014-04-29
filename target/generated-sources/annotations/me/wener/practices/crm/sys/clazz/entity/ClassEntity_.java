package me.wener.practices.crm.sys.clazz.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.wener.practices.crm.sys.lesson.entity.LessonEntity;
import me.wener.practices.crm.sys.student.school.entity.StudentEntity;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClassEntity.class)
public abstract class ClassEntity_ {

	public static volatile SingularAttribute<ClassEntity, Long> id;
	public static volatile SingularAttribute<ClassEntity, Date> startDate;
	public static volatile SingularAttribute<ClassEntity, LessonEntity> lesson;
	public static volatile SetAttribute<ClassEntity, StudentEntity> students;
	public static volatile SingularAttribute<ClassEntity, String> remark;
	public static volatile SingularAttribute<ClassEntity, String> name;
	public static volatile SingularAttribute<ClassEntity, String> state;
	public static volatile SingularAttribute<ClassEntity, Date> endDate;
	public static volatile SingularAttribute<ClassEntity, Integer> version;

}

