package com.geektora.geektora_api.services;

import com.geektora.geektora_api.model.entity.Product;
import com.geektora.geektora_api.repository.article.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductService {

    @Autowired private ProductRepository productRepository;

    public Product createProduct(Product product) {
        product.setIdProduct(null); //JPA se encargará del ID autogenerado
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
        product.setStock(product.getStock());
        product.setImage(product.getImage());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product.setActive(true);
        // product.setTags(product.getTags());
        return productRepository.save(product);
    }
}