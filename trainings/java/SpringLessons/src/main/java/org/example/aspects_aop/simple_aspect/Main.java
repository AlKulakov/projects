package org.example.aspects_aop.simple_aspect;

import org.example.aspects_aop.simple_aspect.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setAuthor("Vitya");
        comment.setText("Nado viyti");
        service.publishComment(comment);
    }
}
