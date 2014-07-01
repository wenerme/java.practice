主要使用的技术栈
---------------

* Spring
* Struts2
* Hibernate-jpa 由 hibernate 实现的 JPA
* GenericDao 一套简单的抽象dao接口
* c3p0 连接池
* javax.inject JSR330 注入方式
* metamodel 由 hibernate jpamodelgen 生成,用于 typesafe 的查找
* jsp-tag 使用的tag模板
* Guava 辅助工具
* lombok 辅助工具,生成大量代码

目前 52 个 JAR 包
* commons-beanutils
54

Note
----

* 没有使用任何 hibernate 相关的API,主要使用的是 JPA.
* 注入时主要是使用的 JSR330 的注入方式

