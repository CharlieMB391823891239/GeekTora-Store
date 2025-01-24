package com.geektora.geektora_api.services;

import com.geektora.geektora_api.DTO.product.ProductCreateDTO;
import com.geektora.geektora_api.exceptions.ResourceNotExistsException;
import com.geektora.geektora_api.mappers.ProductMapper;
import com.geektora.geektora_api.model.entity.Product;
import com.geektora.geektora_api.model.entity.Tag;
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

    public Product createProduct(ProductCreateDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);

        // Verificar que existan los tags
        if (productDTO.getTagIds() != null) {
            List<Tag> tags = productDTO.getTagIds().stream()
                    .map(tagId -> tagRepository.findById(tagId)
                            .orElseThrow(() -> new ResourceNotExistsException("Tag not found with id: " + tagId)))
                    .collect(Collectors.toList());
            product.setTags(tags);
        }

        return productRepository.save(product);
    }
}