package com.geektora.geektora_api.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer idComment;

    @Column(name = "comment",nullable = false, length = 120)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "idProduct",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idClient",nullable = false)
    private Client idClient;

    @Column(name = "createdAt",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "image")
    private String image;

    @Column(name = "counter")
    private Integer Counter;
}
