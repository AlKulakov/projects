package org.example.scope.prototype.by_beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s1 = context.getBean("commentService", CommentService.class);
        var s2 = context.getBean("commentService", CommentService.class);

        boolean b = s1 == s2;
        System.out.println(b);
    }
}
