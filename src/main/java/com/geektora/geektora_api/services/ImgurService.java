package com.geektora.geektora_api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImgurService {

    private final WebClient webClient;

    public ImgurService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.imgur.com/3").build();
    }

    // Método para cargar las imágenes a Imgur
    public List<String> uploadImages(List<MultipartFile> images) {
        List<String> imageUrls = new ArrayList<>();

        // Llamada asíncrona para cada imagen
        for (MultipartFile image : images) {
            String imageUrl = uploadImage(image);
            imageUrls.add(imageUrl);
        }

        return imageUrls;
    }

    // Llamada para subir una imagen a Imgur
    private String uploadImage(MultipartFile image) {
        try {
            // Subir imagen a Imgur
            Mono<String> result = webClient.post()
                    .uri("/image")
                    .header("Authorization", "Client-ID YOUR_CLIENT_ID")
                    .bodyValue(image.getBytes())
                    .retrieve()
                    .bodyToMono(String.class);

            // Aquí podrías manejar la respuesta y obtener la URL de la imagen
            // Suponiendo que la respuesta es un JSON que contiene un campo "link" con la URL
            return result.block(); // Para obtener la URL
        } catch (Exception e) {
            throw new RuntimeException("Error al subir la imagen a Imgur: " + e.getMessage());
        }
    }
}