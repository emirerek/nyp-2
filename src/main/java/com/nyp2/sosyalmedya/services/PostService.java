package com.nyp2.sosyalmedya.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.Post;
import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.PostRepository;
import com.nyp2.sosyalmedya.requests.PostCreateRequest;
import com.nyp2.sosyalmedya.requests.PostUpdateRequest;

@Service
public class PostService {
    
    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findAllByUserId(userId.get());
        } else {
            return postRepository.findAll();
        }
    }

    public List<Post> getAllPostsFromFollowed(Long userId) {
        return postRepository.findLatestPostsByFollowedUsers(userId);
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createPost(PostCreateRequest postCreateRequest) {
        User user = userService.getUserById(postCreateRequest.getUserId());
        if (user == null) {
            return null;
        }
        Post newPost = new Post();
        newPost.setUser(user);
        newPost.setText(postCreateRequest.getText());
        return postRepository.save(newPost);
    }

    public Post updatePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post postToUpdate = post.get();
            postToUpdate.setText(postUpdateRequest.getText());
            return postRepository.save(postToUpdate);
        } else {
            return null;
        }
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

}
