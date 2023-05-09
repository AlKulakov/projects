package org.example.spring_w_qual.repository;

import org.example.spring_w_qual.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
