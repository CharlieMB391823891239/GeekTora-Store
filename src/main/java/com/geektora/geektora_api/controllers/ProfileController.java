package com.geektora.geektora_api.controllers;
//Sin probar todavía
import com.geektora.geektora_api.model.entity.Client;
import com.geektora.geektora_api.model.entity.ProfilePhoto;
import com.geektora.geektora_api.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/upload-image/{userId}")
    public ResponseEntity<String> uploadProfileImage(@PathVariable Integer userId, @RequestParam("image") MultipartFile imageFile) {
        String result = profileService.uploadProfileImage(userId, imageFile);
        return ResponseEntity.ok(result);
    }
}
