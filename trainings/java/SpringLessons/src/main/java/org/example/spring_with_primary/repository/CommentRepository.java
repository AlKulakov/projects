package org.example.spring_with_primary.repository;

import org.example.spring_with_primary.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
