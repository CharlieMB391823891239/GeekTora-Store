package com.geektora.geektora_api.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profile_photo")
public class ProfilePhoto {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer idProfilePhoto;

    @Column(name = "idUser",nullable = false)
    private Integer idUser;

    @Column(name = "image",nullable = false)
    private String image;
}

