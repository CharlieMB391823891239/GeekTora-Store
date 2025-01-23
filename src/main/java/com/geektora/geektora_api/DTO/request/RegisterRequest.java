package com.geektora.geektora_api.DTO.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String contrasena;
}
