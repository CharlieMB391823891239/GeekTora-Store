package com.geektora.geektora_api.repository.article;

import com.geektora.geektora_api.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByProductoId(Integer idProducto);
}
