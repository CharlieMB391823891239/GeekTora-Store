package com.geektora.geektora_api.services;

import com.geektora.geektora_api.DTO.product.ProductCreateDTO;
import com.geektora.geektora_api.exceptions.ResourceNotExistsException;
import com.geektora.geektora_api.mappers.ProductMapper;
import com.geektora.geektora_api.model.entity.Image;
import com.geektora.geektora_api.model.entity.Product;
import com.geektora.geektora_api.model.entity.Tag;
import com.geektora.geektora_api.repository.article.ImageRepository;
import com.geektora.geektora_api.repository.article.ProductRepository;
import com.geektora.geektora_api.repository.article.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired private ProductRepository productRepository;
    @Autowired private TagRepository tagRepository;
    @Autowired private ProductMapper productMapper;
    @Autowired private ImgurService imgurService;
    @Autowired private ImageRepository imageRepository;

    public Product createProduct(ProductCreateDTO productDTO) {
        // Convertir el DTO en entidad Product
        Product product = productMapper.toEntity(productDTO);

        // Verificar si existen tags y asignarlos al producto
        if (productDTO.getTagIds() != null) {
            List<Tag> tags = productDTO.getTagIds().stream()
                    .map(tagId -> tagRepository.findById(tagId)
                            .orElseThrow(() -> new ResourceNotExistsException("Tag not found with id: " + tagId)))
                    .collect(Collectors.toList());
            product.setTags(tags);
        }

        // Guardar el producto inicialmente en la base de datos
        Product savedProduct = productRepository.save(product);

        // Verificar si se han proporcionado imágenes
        if (productDTO.getImages() != null && !productDTO.getImages().isEmpty()) {
            // Subir las imágenes a Imgur y obtener las URLs
            List<String> imageUrls = imgurService.uploadImages(productDTO.getImages());

            // Imprimir las URLs de las imágenes en la consola para verificación
            imageUrls.forEach(url -> System.out.println("Image URL: " + url)); // Usando System.out.println() para imprimir las URLs

            // Crear y asociar las URLs de las imágenes al producto
            List<Image> images = imageUrls.stream()
                    .map(url -> {
                        Image image = new Image();
                        image.setUrl(url);          // Asignar la URL de la imagen
                        image.setProduct(savedProduct);  // Asociar la imagen con el producto guardado
                        return image;
                    })
                    .collect(Collectors.toList());

            // Guardar las imágenes en la base de datos
            imageRepository.saveAll(images);  // Guardar todas las imágenes en la base de datos

            // Asociar las imágenes al producto después de que haya sido guardado
            savedProduct.setImages(images);
        }

        // Retornar el producto con las imágenes asociadas (si las hubo)
        return savedProduct;
    }
}