package org.example.spring_with_primary.proxies;

import org.example.spring_with_primary.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
