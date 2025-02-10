package com.geektora.geektora_api.services.serviceimpl;

import com.geektora.geektora_api.DTO.request.LoginRequest;
import com.geektora.geektora_api.DTO.request.RegisterRequest;
import com.geektora.geektora_api.model.entity.User;
import com.geektora.geektora_api.repository.users.UserRepository;
import com.geektora.geektora_api.services.AuthService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String API_KEY = "d8bb7f04397b68a1e98a2e3f9dd80295";

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
        // Validar formato del correo
        if (!isEmailValidFormat(registerRequest.getEmail())) {
            return "El formato del correo es inválido";
        }

        // Validar si el correo existe realmente
        if (!isEmailReal(registerRequest.getEmail())) {
            return "El correo ingresado no existe";
        }

        // Validar unicidad
        if (userRepository.findByName(registerRequest.getName()).isPresent()) {
            return "El nombre de usuario ya está en uso";
        }
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return "El correo ya está en uso";
        }

        // Registrar usuario
        User newUser = new User();
        newUser.setName(registerRequest.getName());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setContrasena(registerRequest.getContrasena());

        userRepository.save(newUser);
        return "Registro exitoso";
    }

    // Validar formato del correo
    private boolean isEmailValidFormat(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Validar si el correo realmente existe con MailboxLayer
    private boolean isEmailReal(String email) {
        try {
            String apiUrl = "http://apilayer.net/api/check?access_key=" + API_KEY + "&email=" + email;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = reader.readLine();
            reader.close();

            JSONObject jsonResponse = new JSONObject(response);
            return jsonResponse.getBoolean("smtp_check"); // Si es true, el correo existe
        } catch (Exception e) {
            return false; // En caso de error, asumimos que el correo no es válido
        }
    }
}