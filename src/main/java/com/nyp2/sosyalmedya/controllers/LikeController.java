package com.nyp2.sosyalmedya.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyp2.sosyalmedya.entities.Like;
import com.nyp2.sosyalmedya.requests.LikeCreateRequest;
import com.nyp2.sosyalmedya.services.LikeService;

@Controller
@RequestMapping("/likes")
public class LikeController {
    
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/likes/{userId}")
    public List<Like> getUserLikes(@RequestParam Long userId) {
        return likeService.getLikesByUserId(userId);
    }

    @GetMapping("/likes/{postId}")
    public List<Like> getPostLikes(@RequestParam Long postId) {
        return likeService.getLikesByPostId(postId);
    }
    
    @PostMapping
    public Like createLike(@RequestParam LikeCreateRequest likeCreateRequest) {
        return likeService.createLike(likeCreateRequest);
    }

    @DeleteMapping
    public void deleteLike(@RequestParam Long likeId) {
        likeService.deleteLike(likeId);
    }

}
