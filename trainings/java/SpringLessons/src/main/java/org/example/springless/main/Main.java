package org.example.springless.main;

import org.example.springless.model.Comment;
import org.example.springless.proxies.EmailCommentNotificationProxy;
import org.example.springless.repositories.DBCommentRepository;
import org.example.springless.services.CommentService;

public class Main {
    public static void main(String[] args) {

        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        var commentService = new CommentService(commentRepository, commentNotificationProxy);
        var comment = new Comment();
        comment.setText("Azaza");
        comment.setAuthor("leks");
        commentService.publicComment(comment);
    }
}
