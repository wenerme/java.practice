package me.wener.practices.crm.sys.employee.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.wener.practices.crm.sys.department.entity.DepartmentEntity;
import me.wener.practices.web.common.entity.Sex;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, Date> joinDate;
	public static volatile SingularAttribute<UserEntity, Long> id;
	public static volatile SingularAttribute<UserEntity, Date> birthday;
	public static volatile SingularAttribute<UserEntity, Sex> sex;
	public static volatile SingularAttribute<UserEntity, DepartmentEntity> department;
	public static volatile SingularAttribute<UserEntity, String> name;
	public static volatile SingularAttribute<UserEntity, String> account;
	public static volatile SingularAttribute<UserEntity, String> number;
	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, Integer> version;

}

