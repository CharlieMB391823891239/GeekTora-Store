package com.geektora.geektora_api.controllers;

import com.geektora.geektora_api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired private CommentService commentService;

    @DeleteMapping("/delete/{idComment}")
    public void deleteComment(@PathVariable Integer idComment) {
        commentService.deleteComment(idComment);
    }
}
