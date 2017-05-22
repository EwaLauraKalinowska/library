package pl.ewa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by ewcia on 20.04.17.
 */
@Configuration
@PropertySource(value = "classpath:hibernate.properties")
@EnableJpaRepositories(basePackages ="pl.ewa.dao" )
public class HibernateConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver.class.name"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.user.name"));
        dataSource.setUrl("jdbc.url");


        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityMenagerFactory(){

        HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();

        Properties properties =new Properties();
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        properties.put("hibernate.generate_statistic", environment.getProperty("hibernate.generate_statistic"));

        LocalContainerEntityManagerFactoryBean factoryBean= new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("pl.ewa.model");
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(properties);
        factoryBean.setDataSource(dataSource());
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        JpaTransactionManager transactionManager= new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityMenagerFactory());

        return transactionManager;
    }
}