package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan(value = {
        "com.example.demo.dao",
        "com.example.demo.service"
})
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        Properties properties = new Properties();

        //db settings

        properties.put(DRIVER, env.getProperty("spring.datasource.driver-class-name"));
        properties.put(URL, env.getProperty("spring.datasource.url"));
        properties.put(USER, env.getProperty("spring.datasource.username"));
        properties.put(PASS, env.getProperty("spring.datasource.password"));

        //hibernate settings

        properties.put(SHOW_SQL, env.getProperty("spring.jpa.show-sql"));
        properties.put(HBM2DDL_AUTO, env.getProperty("spring.jpa.hibernate.ddl-auto"));

        //pull settings

        properties.put(C3P0_MIN_SIZE,env.getProperty("hibernate.c3p0.min_size"));
        properties.put(C3P0_MAX_SIZE,env.getProperty("hibernate.c3p0.max_size"));
        properties.put(C3P0_ACQUIRE_INCREMENT,env.getProperty("hibernate.c3p0.acquire_increment"));
        properties.put(C3P0_TIMEOUT,env.getProperty("hibernate.c3p0.timeout"));
        properties.put(C3P0_MAX_STATEMENTS,env.getProperty("hibernate.c3p0.max_statements"));

        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setPackagesToScan("com.example.demo.model");

        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());

        return transactionManager;
    }
}
