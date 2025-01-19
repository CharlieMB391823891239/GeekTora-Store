package com.geektora.geektora_api.services;

import com.geektora.geektora_api.DTO.comment.CommentDTO;
import com.geektora.geektora_api.DTO.comment.UpdateCommentDTO;
import com.geektora.geektora_api.exceptions.ResourceNotExistsException;
import com.geektora.geektora_api.mappers.CommentMapper;
import com.geektora.geektora_api.model.entity.Comment;
import com.geektora.geektora_api.repository.article.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired private CommentRepository commentRepository;
    @Autowired private CommentMapper commentMapper;

    public CommentDTO updateComment(UpdateCommentDTO updateCommentDTO, Integer idComment) {
        Comment comment = commentRepository.findById(idComment).orElseThrow(() -> new ResourceNotExistsException("No se encontró el comentario"));
        comment.setComment(updateCommentDTO.getComment());
        comment.setImage(updateCommentDTO.getImage());
        comment.setCounter(comment.getCounter() + 1);
        comment.setUpdatedAt(LocalDateTime.now());
        return commentMapper.toDTO(commentRepository.save(comment));
    }

    public void deleteComment(Integer idComment) {
        commentRepository.deleteById(idComment);
    }
}