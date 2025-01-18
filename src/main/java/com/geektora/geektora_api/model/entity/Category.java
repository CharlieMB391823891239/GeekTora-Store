package com.geektora.geektora_api.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer idCategory;

    @Column(name = "name-category",nullable = false, length = 100)
    private String nameCategory;

    @Column(name = "description",nullable = false, length = 120)
    private String description;

    @Column(name = "active")
    private Boolean active;
}
