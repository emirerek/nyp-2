package com.nyp2.sosyalmedya.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.Like;
import com.nyp2.sosyalmedya.entities.Post;
import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.LikeRepository;
import com.nyp2.sosyalmedya.requests.LikeCreateRequest;

@Service
public class LikeService {

    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }
    
    public List<Like> getLikesByUserId(Long userId) {
        return likeRepository.findByUserId(userId);
    }

    public List<Like> getLikesByPostId(Long postId) {
        return likeRepository.findByPostId(postId);
    }

    public Like createLike(LikeCreateRequest likeCreateRequest) {
        User user = userService.getUserById(likeCreateRequest.getUserId());
        Post post = postService.getPostById(likeCreateRequest.getPostId());
        if (user == null || post == null) {
            return null;
        }
        Like newLike = new Like();
        newLike.setPost(post);
        newLike.setUser(user);
        return likeRepository.save(newLike); 
    }

    public void deleteLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }

}
