package org.example.scope.singleton.by_stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private CommentRepository commentRepository;
    public CommentRepository getCommentRepository(){
        return this.commentRepository;
    }
}
