package com.geektora.geektora_api.mappers;

import com.geektora.geektora_api.DTO.comment.CommentDTO;
import com.geektora.geektora_api.DTO.comment.CreateCommentDTO;
import com.geektora.geektora_api.model.entity.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    @Autowired ModelMapper modelMapper;

    public CommentDTO toDTO(Comment comment) {
        return modelMapper.map(comment, CommentDTO.class);
    }
}
