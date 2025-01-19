package com.geektora.geektora_api.DTO.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class CommentDTO {
    private Integer idComment;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String image;
    private Integer counter;
}
