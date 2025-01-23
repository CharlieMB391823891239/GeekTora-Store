package com.geektora.geektora_api.DTO.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String identifier; // Puede ser correo o nombre de usuario
    private String contrasena;
}

