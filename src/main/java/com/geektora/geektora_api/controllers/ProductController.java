package com.geektora.geektora_api.controllers;

import com.geektora.geektora_api.model.entity.Comment;
import com.geektora.geektora_api.model.entity.Product;
import com.geektora.geektora_api.services.CommentService;
import com.geektora.geektora_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}/comentarios")
    public ResponseEntity<List<Comment>> obtenerComentarios(@PathVariable Integer id) {
        List<Comment> comentarios = productService.getCommentsByProduct(id);
        return ResponseEntity.ok(comentarios);
    }
}
