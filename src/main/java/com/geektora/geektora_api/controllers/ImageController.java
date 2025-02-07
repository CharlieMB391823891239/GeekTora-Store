package com.geektora.geektora_api.controllers;

import com.geektora.geektora_api.DTO.image.ImageResponseDTO;
import com.geektora.geektora_api.model.entity.Image;
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
    public ResponseEntity<List<ImageResponseDTO>> uploadImages(@RequestParam("files") List<MultipartFile> files) {
        try {
            return ResponseEntity.ok(imgurService.uploadImages(files));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Image>> getImagesFromImgur() {
        try {
            List<Image> images = imgurService.getImagesFromImgur();
            return ResponseEntity.ok(images);  // Retornamos la lista de imágenes en el cuerpo de la respuesta
        } catch (Exception e) {
            // Imprime el error para poder rastrear el problema y devuelve un error 500
            System.err.println("Error obteniendo imágenes: " + e.getMessage());
            return ResponseEntity.status(500).body(null); // Cambié el 404 a 500 ya que es un error del servidor
        }
    }
}