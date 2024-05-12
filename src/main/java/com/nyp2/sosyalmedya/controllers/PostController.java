package com.nyp2.sosyalmedya.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyp2.sosyalmedya.entities.Post;
import com.nyp2.sosyalmedya.requests.PostCreateRequest;
import com.nyp2.sosyalmedya.requests.PostUpdateRequest;
import com.nyp2.sosyalmedya.services.PostService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {
    
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping()
    public List<Post> getAllPostsFromFollowed(@RequestParam Long userId) {
        return postService.getAllPostsFromFollowed(userId);
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping()
    public Post createPost(@Valid @RequestBody PostCreateRequest postCreateRequest) {
        return postService.createPost(postCreateRequest);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody PostUpdateRequest postUpdateRequest) {
        return postService.updatePost(postId, postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

}
