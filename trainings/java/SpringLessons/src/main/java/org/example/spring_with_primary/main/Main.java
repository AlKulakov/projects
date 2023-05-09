package org.example.spring_with_primary.main;

import org.example.spring_with_primary.model.Comment;
import org.example.spring_with_primary.service.CommentService;
import org.example.spring_with_primary.configuration.ProjectConfiguration;
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
