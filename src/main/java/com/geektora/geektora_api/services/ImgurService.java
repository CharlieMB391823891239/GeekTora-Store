package com.geektora.geektora_api.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImgurService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Value("${imgur.api.url}") // ✅ Cargar la URL desde application.properties
    private String imgurApiUrl;

    @Value("${imgur.bearer.token}") // ✅ Token de acceso de Imgur
    private String bearerToken;

    public ImgurService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.build();
        this.objectMapper = objectMapper;
    }

    public List<String> uploadImages(List<MultipartFile> images) {
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile image : images) {
            try {
                String imageUrl = uploadImage(image);
                if (imageUrl != null) {
                    imageUrls.add(imageUrl);
                }
            } catch (Exception e) {
                System.err.println("Error subiendo imagen: " + e.getMessage());
            }
        }
        return imageUrls;
    }

    private String uploadImage(MultipartFile image) throws Exception {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", image.getResource()); // ✅ Enviar la imagen
        body.add("type", "image"); // ✅ Especificar tipo de archivo

        Mono<String> responseMono = webClient.post()
                .uri(imgurApiUrl) // ✅ Usar la URL configurada en application.properties
                .header("Authorization", "Bearer " + bearerToken) // ✅ Usar Bearer Token para cuenta
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class);

        String responseBody = responseMono.block(); // Bloquear para obtener la respuesta

        JsonNode jsonNode = objectMapper.readTree(responseBody);
        if (jsonNode.path("success").asBoolean()) {
            return jsonNode.path("data").path("link").asText();
        } else {
            throw new RuntimeException("Error en Imgur: " + jsonNode.path("data").path("error").asText());
        }
    }
}
