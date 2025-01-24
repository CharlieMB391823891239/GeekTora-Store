package com.geektora.geektora_api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTag;

    @Column(name = "name",nullable = false, length = 100)
    private String name;

    @Column(name = "description",nullable = false, length = 120)
    private String description;

    @Column(name = "active")
    private Boolean active;

    @JsonIgnore
    @ManyToMany(mappedBy = "tags",fetch = FetchType.LAZY)
    private List<Product>products;
}
