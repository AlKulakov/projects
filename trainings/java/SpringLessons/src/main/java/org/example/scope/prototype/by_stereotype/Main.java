package org.example.scope.prototype.by_stereotype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = c.getBean(CommentService.class);
        var user = c.getBean(UserService.class);
        boolean b = comment.getCommentRepository() == user.getCommentRepository();
        System.out.println(b);
    }
}
