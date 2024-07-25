package org.example.old.config;

import org.example.old.beans.Parrot;
import org.example.old.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.old.beans")
public class ProjectConfig {


    @Bean
    public Parrot parrot1(){
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }
    @Bean
    public Parrot parrot2(){
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }
//    @Bean
//    public Person person("@Qualifier("parrot2") Parrot parrot){
//        Person p = new Person();
//        p.setName("Ella");
//        p.setParrot(parrot);
//        return p;
//    }
//
//
//
//    @Bean(name="Ivan")
//    Apple apple1(){
//        var apple = new Apple();
//        apple.setName("Green Apple");
//        return apple;
//    }
//    @Primary
//    @Bean
//    Apple apple2(){
//        var apple = new Apple();
//        apple.setName("Red Apple");
//        return apple;
//    }
    @Bean
    String hello(){
        return "Hi";
    }
}
