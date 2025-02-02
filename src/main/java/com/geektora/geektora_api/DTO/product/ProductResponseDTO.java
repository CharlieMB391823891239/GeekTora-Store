package com.geektora.geektora_api.DTO.product;

import com.geektora.geektora_api.DTO.image.ImageResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductResponseDTO {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private List<Integer> tagIds;
    private List<ImageResponseDTO> images;
}
