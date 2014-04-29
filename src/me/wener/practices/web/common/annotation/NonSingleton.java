package me.wener.practices.web.common.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 在使用 Spring 时,用于指定不使用单例的 bean
 */
@Documented
@Retention(RUNTIME)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public @interface NonSingleton
{
}
