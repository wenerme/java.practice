package me.wener.practices.crm.sys.student.counsel.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.wener.practices.crm.sys.clazz.entity.ClassEntity;
import me.wener.practices.web.common.entity.Sex;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CounselInfoEntity.class)
public abstract class CounselInfoEntity_ {

	public static volatile SingularAttribute<CounselInfoEntity, ClassEntity> intentionClass;
	public static volatile SingularAttribute<CounselInfoEntity, Long> id;
	public static volatile SingularAttribute<CounselInfoEntity, Sex> sex;
	public static volatile SingularAttribute<CounselInfoEntity, String> phone;
	public static volatile SingularAttribute<CounselInfoEntity, String> school;
	public static volatile SingularAttribute<CounselInfoEntity, String> remark;
	public static volatile SingularAttribute<CounselInfoEntity, String> address;
	public static volatile SingularAttribute<CounselInfoEntity, String> QQ;
	public static volatile SingularAttribute<CounselInfoEntity, Integer> age;
	public static volatile SingularAttribute<CounselInfoEntity, String> name;
	public static volatile SingularAttribute<CounselInfoEntity, String> education;
	public static volatile SingularAttribute<CounselInfoEntity, Integer> version;

}

