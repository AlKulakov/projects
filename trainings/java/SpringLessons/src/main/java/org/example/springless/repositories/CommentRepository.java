package org.example.springless.repositories;

import org.example.springless.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
