package org.example.spring_w_qual.proxies;

import org.example.spring_w_qual.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
