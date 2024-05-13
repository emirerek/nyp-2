package com.nyp2.sosyalmedya.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nyp2.sosyalmedya.entities.Like;
import com.nyp2.sosyalmedya.requests.LikeCreateRequest;
import com.nyp2.sosyalmedya.responses.PostResponse;
import com.nyp2.sosyalmedya.services.LikeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/likes")
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class LikeController {
    
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping()
    public List<PostResponse> getAllLikes(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId) {
        return likeService.getAllLikes(postId, userId);
    }

    @GetMapping("/{postId}")
    public boolean isLiked(@PathVariable Long postId, @RequestParam Long userId) {
        return likeService.isLiked(postId, userId);
    }
    
    @PostMapping()
    public Like createLike(@Valid @RequestBody LikeCreateRequest likeCreateRequest) {
        return likeService.createLike(likeCreateRequest);
    }

    @DeleteMapping()
    public void deleteLike(@RequestParam Long postId, @RequestParam Long userId) {
        likeService.deleteLike(postId, userId);
    }

}
