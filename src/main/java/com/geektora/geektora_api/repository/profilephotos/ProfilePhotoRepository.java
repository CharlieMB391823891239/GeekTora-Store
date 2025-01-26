package com.geektora.geektora_api.repository.profilephotos;

import com.geektora.geektora_api.model.entity.ProfilePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePhotoRepository extends JpaRepository<ProfilePhoto, Integer> {
}
