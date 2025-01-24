package com.geektora.geektora_api.controllers;

import com.geektora.geektora_api.DTO.product.ProductCreateDTO;
import com.geektora.geektora_api.model.entity.Product;
import com.geektora.geektora_api.repository.article.ProductRepository;
import com.geektora.geektora_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody ProductCreateDTO productDTO) {
        return productService.createProduct(productDTO);
    }
}
