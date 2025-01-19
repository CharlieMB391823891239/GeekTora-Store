package com.geektora.geektora_api.services;

import com.geektora.geektora_api.repository.article.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired private CommentRepository commentRepository;

    public void deleteComment(Integer idComment) {
        commentRepository.deleteById(idComment);
    }
}