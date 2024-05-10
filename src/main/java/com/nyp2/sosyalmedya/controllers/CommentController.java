package com.nyp2.sosyalmedya.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nyp2.sosyalmedya.entities.Comment;
import com.nyp2.sosyalmedya.requests.CommentCreateRequest;
import com.nyp2.sosyalmedya.requests.CommentUpdateRequest;
import com.nyp2.sosyalmedya.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
    
    private CommentService commentService;
    
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable Long commentId) {
        return commentService.getComment(commentId);
    }

    @GetMapping("/{postId}")
    public List<Comment> getPostComments(@RequestParam Long postId) {
        return commentService.getPostComments(postId);
    }

    @GetMapping("/{userId}")
    public List<Comment> getAllComments(@RequestParam Long userId) {
        return commentService.getUserComments(userId);
    }

    @PostMapping
    public Comment createComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.createComment(commentCreateRequest);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return commentService.updateComment(commentId, commentUpdateRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

}
