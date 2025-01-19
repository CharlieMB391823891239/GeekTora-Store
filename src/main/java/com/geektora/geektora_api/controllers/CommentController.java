package com.geektora.geektora_api.controllers;

import com.geektora.geektora_api.DTO.comment.CommentDTO;
import com.geektora.geektora_api.DTO.comment.UpdateCommentDTO;
import com.geektora.geektora_api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired private CommentService commentService;

    @PatchMapping("/update/{idComment}")
    public CommentDTO updateComment(@PathVariable Integer idComment, @RequestBody UpdateCommentDTO updateCommentDTO) {
        return commentService.updateComment(updateCommentDTO, idComment);
    }

    @DeleteMapping("/delete/{idComment}")
    public void deleteComment(@PathVariable Integer idComment) {
        commentService.deleteComment(idComment);
    }
}
