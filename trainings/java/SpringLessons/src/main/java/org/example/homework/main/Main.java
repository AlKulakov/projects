package org.example.homework.main;

import org.example.homework.beans.Human;
import org.example.homework.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Human Bill = context.getBean(Human.class);
        Bill.use();
    }
}
