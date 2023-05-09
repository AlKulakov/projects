package org.example.scope.singleton.by_stereotype;

import org.example.old.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(560);
        list.add(850);
        list.add(960);
        list.add(830);
        list.add(180);
        list.add(650);
        list.add(230);
        list.add(320);
        Stream stream = list.stream();
        stream.sorted().mapToInt(e-> (int) e).filter(e->e>0).map(e->e+10).forEach(System.out::println);*/

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var s1=context.getBean(CommentService.class);
        var s2=context.getBean(UserService.class);

        boolean b=s1.getCommentRepository() == s2.getCommentRepository();
        System.out.println(b);
    }
}
