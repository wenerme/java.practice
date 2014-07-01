package me.wener.learn.jk;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import me.wener.learn.jk.domain.EntityPkg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackageClasses = JKPkg.class, includeFilters = @ComponentScan.Filter(Named.class))
@EnableTransactionManagement
@ImportResource("classpath:beans.xml")
//@EnableJpaRepositories(basePackageClasses = RepoPkg.class, includeFilters = @ComponentScan.Filter(Named.class))
public class SpringContextConfig
{

}
