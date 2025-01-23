package com.geektora.geektora_api.services;

import com.geektora.geektora_api.exceptions.ResourceNotExistsException;
import com.geektora.geektora_api.model.entity.Comment;
import com.geektora.geektora_api.repository.article.CommentRepository;
import com.geektora.geektora_api.repository.article.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productoRepository;
    @Autowired
    CommentRepository comentarioRepository;


    public List<Comment> getCommentsByProduct(Integer idProduct) {
        productoRepository.findById(idProduct)
                .orElseThrow(() -> new ResourceNotExistsException("No se encontró el producto"));

        return comentarioRepository.findByProductoId(idProduct);
    }
}

