package me.wener.practices.crm.sys.department.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.wener.practices.crm.sys.employee.entity.UserEntity;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DepartmentEntity.class)
public abstract class DepartmentEntity_ {

	public static volatile SingularAttribute<DepartmentEntity, Long> id;
	public static volatile SingularAttribute<DepartmentEntity, String> description;
	public static volatile SingularAttribute<DepartmentEntity, String> name;
	public static volatile SingularAttribute<DepartmentEntity, Integer> version;
	public static volatile SetAttribute<DepartmentEntity, UserEntity> employees;

}

