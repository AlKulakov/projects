package org.example.spring_with_primary.proxies;

import org.example.spring_with_primary.model.Comment;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PushCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Pushing comment: " + comment.getText());
    }

}
