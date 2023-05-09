package org.example.springless.proxies;

import org.example.springless.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
