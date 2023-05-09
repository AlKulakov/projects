package org.example.spring_w_qual.main;

import org.example.spring_w_qual.configuration.ProjectConfiguration;
import org.example.spring_w_qual.model.Comment;
import org.example.spring_w_qual.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment();
        comment.setText("Azaza");
        comment.setAuthor("leks");
        var commentService=context.getBean(CommentService.class);
        commentService.publicComment(comment);
    }
}
