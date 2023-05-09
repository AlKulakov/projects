package org.example.springless.services;

import org.example.springless.model.Comment;
import org.example.springless.proxies.CommentNotificationProxy;
import org.example.springless.repositories.CommentRepository;
import org.springframework.stereotype.Component;

public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }
    public void publicComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
