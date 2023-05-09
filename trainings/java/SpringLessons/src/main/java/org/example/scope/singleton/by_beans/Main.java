package org.example.scope.singleton.by_beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var newComServ1 = context.getBean(CommentService.class);
        var newComServ2 = context.getBean(CommentService.class);

        boolean compareObj = newComServ1 == newComServ2;
        System.out.println(compareObj);
    }
}
