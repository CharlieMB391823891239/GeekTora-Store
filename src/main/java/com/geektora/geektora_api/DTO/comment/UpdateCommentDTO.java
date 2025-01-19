package com.geektora.geektora_api.DTO.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCommentDTO {
    private String comment;
    private String image;
}
