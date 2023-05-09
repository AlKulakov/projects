package org.example.old.main;

import org.example.old.beans.Person;
import org.example.old.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
//
//        //Создание бина через @Bean
//        Apple apple = context.getBean( "Ivan", Apple.class);
//        System.out.println(apple.getName());
//
//        String hello = context.getBean(String.class);
//        System.out.println(hello);
//
//            //Создание бина через @Component и @ComponentScan(basePackages = "address")
//        Man man = context.getBean(Man.class);
//        System.out.println(man.getDesc());
//
//        //Программное создание бинов
//        var incel = new Incel();
//        Supplier<Incel> incelSupplier = () -> incel;
//        context.registerBean("IncelBlackpilled",
//                Incel.class,
//                incelSupplier,
//                incelB -> incelB.setPrimary(true));
//        var incelism = context.getBean(Incel.class);
//        System.out.println(incelism.getCry());

        //Parrot parrot = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);
        System.out.println(person.getParrot());
    }
}