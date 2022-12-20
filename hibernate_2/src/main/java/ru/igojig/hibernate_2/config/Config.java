package ru.igojig.hibernate_2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.igojig.hibernate_2")
public class Config {
//    @Bean(name ="sessionFactory")
//    @Scope("singleton")
//    public SessionFactory sessionFactory(){
//        return new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//    }


}
