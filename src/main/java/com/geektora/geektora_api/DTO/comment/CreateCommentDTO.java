package com.geektora.geektora_api.DTO.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCommentDTO {
    private String comment;
    private String image;
    private Integer counter;
    private Integer idProduct;
    private Integer idClient;
}
