package org.example.scope.singleton.by_lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class psvm {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s = context.getBean(CommentService.class);
    }
}
