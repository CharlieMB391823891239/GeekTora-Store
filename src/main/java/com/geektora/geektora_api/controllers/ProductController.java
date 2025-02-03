package com.geektora.geektora_api.controllers;

import com.geektora.geektora_api.DTO.product.ProductCreateDTO;
import com.geektora.geektora_api.DTO.product.ProductResponseDTO;
import com.geektora.geektora_api.exceptions.ResourceNotExistsException;
import com.geektora.geektora_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Recibe un formulario multipart con datos del producto y las imágenes
    @PostMapping("/create")
    public ProductResponseDTO createProduct(@RequestParam("name") String name,
                                            @RequestParam("description") String description,
                                            @RequestParam("price") Double price,
                                            @RequestParam("stock") Integer stock,
                                            @RequestParam("tagIds") List<Integer> tagIds,
                                            @RequestParam("categoryIds") List<Integer> categoryIds,
                                            @RequestParam("images") List<MultipartFile> images) {
        // Crear DTO con los datos
        ProductCreateDTO productDTO = new ProductCreateDTO(name, description, price, stock, tagIds, categoryIds, images);

        // Llamar al servicio para crear el producto y obtener el DTO de respuesta
        return productService.createProduct(productDTO);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> editProduct(@PathVariable("id") int idProduct,
                                                          @RequestParam("name") String name,
                                                          @RequestParam("description") String description,
                                                          @RequestParam("price") Double price,
                                                          @RequestParam("stock") Integer stock,
                                                          @RequestParam("tagIds") List<Integer> tagIds,
                                                          @RequestParam("categoryIds") List<Integer> categoryIds,
                                                          @RequestPart(value = "images", required = false) List<MultipartFile> images) {
        // Crear el DTO con los datos recibidos
        ProductCreateDTO productDTO = new ProductCreateDTO(name, description, price, stock, tagIds, categoryIds, images);

        // Llamar al servicio para editar el producto
        ProductResponseDTO updatedProduct = productService.editProduct(idProduct, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }
}