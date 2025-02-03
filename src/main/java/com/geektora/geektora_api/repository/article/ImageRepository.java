package com.geektora.geektora_api.repository.article;

import com.geektora.geektora_api.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
