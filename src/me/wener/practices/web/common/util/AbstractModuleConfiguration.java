package me.wener.practices.web.common.util;


import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class AbstractModuleConfiguration
        implements ApplicationContextAware
{
    @Getter
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<? extends T> clazz, boolean checkDep)
    {
        return (T) getApplicationContext().getAutowireCapableBeanFactory()
                .autowire(clazz, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, checkDep);
    }

    /**
     * 以 {@link AutowireCapableBeanFactory#AUTOWIRE_BY_TYPE} 的方式创建
     * 实例,默认为<b>检测依赖</b>.
     * <p/>
     * 主要用于创建一般的实例
     *
     * @return 创建的实例
     */
    public <T> T newInstance(Class<? extends T> clazz)
    {
        return newInstance(clazz, true);
    }

    @SuppressWarnings("unchecked")
    public <T> T newEntity(Class<? extends T> clazz, boolean checkDep)
    {
        return (T) getApplicationContext().getAutowireCapableBeanFactory()
                .autowire(clazz, AutowireCapableBeanFactory.AUTOWIRE_NO, checkDep);
    }

    /**
     * 以 {@link AutowireCapableBeanFactory#AUTOWIRE_NO} 的方式创建
     * 实例,默认为<b>不</b>检测依赖.
     * <p/>
     * 主要用于创建 实体 类,避免循环依赖.
     *
     * @return 创建的实例
     */
    public <T> T newEntity(Class<? extends T> clazz)
    {
        return newEntity(clazz, false);
    }
}
