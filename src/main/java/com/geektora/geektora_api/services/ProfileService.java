package com.geektora.geektora_api.services;

import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {
    String uploadProfileImage(Integer userId, MultipartFile imageFile);
}