package org.example.springness;

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
