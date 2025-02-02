package com.geektora.geektora_api.controllers;

import com.geektora.geektora_api.services.ImgurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImgurService imgurService;

    public ImageController(ImgurService imgurService) {
        this.imgurService = imgurService;
    }

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadImages(@RequestParam("files") List<MultipartFile> files) {
        try {
            List<String> imageUrls = imgurService.uploadImages(files);
            return ResponseEntity.ok(imageUrls);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(List.of("Error uploading images: " + e.getMessage()));
        }
    }
}