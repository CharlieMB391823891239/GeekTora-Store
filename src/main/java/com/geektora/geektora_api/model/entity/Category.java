package com.geektora.geektora_api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {
    private Integer idCategory;
    private String nameCategory;
    private String description;
    private Boolean active;
}
