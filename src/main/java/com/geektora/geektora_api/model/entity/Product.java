package com.geektora.geektora_api.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column(name = "name",nullable = false, length = 100)
    private String name;

    @Column(name = "description",nullable = false, length = 120)
    private String description;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "createdAt",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "active")
    private Boolean active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idTag")
    )
    private List<Tag> tags;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Comment> comments;
}
