package com.geektora.geektora_api.services.serviceimpl;

import com.geektora.geektora_api.DTO.request.LoginRequest;
import com.geektora.geektora_api.DTO.request.RegisterRequest;
import com.geektora.geektora_api.model.entity.User;
import com.geektora.geektora_api.repository.users.UserRepository;
import com.geektora.geektora_api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(LoginRequest loginRequest) {
        // Buscar por nombre de usuario o correo
        Optional<User> userOptional = userRepository.findByName(loginRequest.getIdentifier());
        if (userOptional.isEmpty()) {
            userOptional = userRepository.findByEmail(loginRequest.getIdentifier());
        }

        // Verificar credenciales
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getContrasena().equals(loginRequest.getContrasena())) {
                return "Inicio de sesión exitoso";
            }
        }
        return "Credenciales inválidas";
    }

    @Override
    public String register(RegisterRequest registerRequest) {
        // Validar que el correo y el nombre de usuario sean únicos
        if (userRepository.findByName(registerRequest.getName()).isPresent()) {
            return "El nombre de usuario ya está en uso";
        }
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return "El correo ya está en uso";
        }

        // Crear el usuario
        User newUser = new User();
        newUser.setName(registerRequest.getName());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setContrasena(registerRequest.getContrasena());

        userRepository.save(newUser);
        return "Registro exitoso";
    }
}