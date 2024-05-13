package com.nyp2.sosyalmedya.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.Post;
import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.PostRepository;
import com.nyp2.sosyalmedya.repositories.UserRepository;
import com.nyp2.sosyalmedya.requests.PostCreateRequest;
import com.nyp2.sosyalmedya.requests.PostUpdateRequest;
import com.nyp2.sosyalmedya.responses.PostResponse;
import com.nyp2.sosyalmedya.responses.UserResponse;

@Service
public class PostService {
    
    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            List<Post> posts = postRepository.findAllByUserId(userId.get());
            return posts.stream()
                .map(this::convertToPostResponse)
                .collect(Collectors.toList());
        } else {
            List<Post> posts = postRepository.findAll();
            return posts.stream()
                .map(this::convertToPostResponse)
                .collect(Collectors.toList());
        }
    }

    public List<PostResponse> getAllPostsFromFollowed(Long userId) {
        List<Post> posts = postRepository.findLatestPostsByFollowedUsers(userId);
        return posts.stream()
            .map(this::convertToPostResponse)
            .collect(Collectors.toList());
    }

    public PostResponse getPostById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (!post.isPresent()) {
            return null;
        }
        return this.convertToPostResponse(post.get());
    }

    public Post createPost(PostCreateRequest postCreateRequest) {
        Optional<User> user = userRepository.findById(postCreateRequest.getUserId());
        if (!user.isPresent()) {
            return null;
        }
        Post newPost = new Post();
        newPost.setUser(user.get());
        newPost.setTextContent(postCreateRequest.getTextContent());
        newPost.setCreationDate(LocalDateTime.now());
        return postRepository.save(newPost);
    }

    public Post updatePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if (!post.isPresent()) {
            return null;
        }
        Post postToUpdate = post.get();
        postToUpdate.setTextContent(postUpdateRequest.getTextContent());
        return postRepository.save(postToUpdate);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    private PostResponse convertToPostResponse(Post post) {

        UserResponse userResponse = new UserResponse(
            post.getUser().getId(), 
            post.getUser().getUsername(),
            post.getUser().getFollowers().size(),
            post.getUser().getFollows().size()
        );
        return new PostResponse(
            post.getId(), 
            userResponse, 
            post.getTextContent(), 
            post.getCreationDate(),
            post.getLikes().size(),
            post.getComments().size()
        );
    }

}
