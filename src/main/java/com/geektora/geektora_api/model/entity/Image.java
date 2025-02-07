package com.geektora.geektora_api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImage;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "delete_hash", nullable = false)
    private String deleteHash;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    @JsonIgnore
    private Product product;

    public Integer getIdProduct() {
        return product != null ? product.getIdProduct() : null;
    }
}