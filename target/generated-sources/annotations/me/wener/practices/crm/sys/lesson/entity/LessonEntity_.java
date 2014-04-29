package me.wener.practices.crm.sys.lesson.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LessonEntity.class)
public abstract class LessonEntity_ {

	public static volatile SingularAttribute<LessonEntity, Long> id;
	public static volatile SingularAttribute<LessonEntity, String> description;
	public static volatile SingularAttribute<LessonEntity, String> name;
	public static volatile SingularAttribute<LessonEntity, String> period;
	public static volatile SingularAttribute<LessonEntity, Double> cost;
	public static volatile SingularAttribute<LessonEntity, Integer> version;

}

