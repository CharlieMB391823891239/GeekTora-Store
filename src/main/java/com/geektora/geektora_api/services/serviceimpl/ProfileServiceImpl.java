package com.geektora.geektora_api.services.serviceimpl;

import com.geektora.geektora_api.model.entity.Client;
import com.geektora.geektora_api.model.entity.ProfilePhoto;
import com.geektora.geektora_api.repository.users.ClientRepository;
import com.geektora.geektora_api.repository.profilephotos.ProfilePhotoRepository;
import com.geektora.geektora_api.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProfilePhotoRepository profilePhotoRepository;

    @Override
    public String uploadProfileImage(Integer userId, MultipartFile imageFile) {
        Optional<Client> clientOptional = clientRepository.findById(userId);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();

            try {
                // Simulación: Guardar la URL o la ruta de la imagen cargada (puedes usar un servicio como AWS S3 o una carpeta local)
                String imageUrl = "path/to/image/" + imageFile.getOriginalFilename();

                ProfilePhoto profilePhoto = new ProfilePhoto();
                profilePhoto.setImage(imageUrl);
                profilePhotoRepository.save(profilePhoto);

                client.setProfilePhoto(profilePhoto);
                clientRepository.save(client);

                return "Imagen de perfil cargada exitosamente.";
            } catch (Exception e) {
                return "Error al cargar la imagen: " + e.getMessage();
            }
        }
        return "Usuario no encontrado.";
    }
}