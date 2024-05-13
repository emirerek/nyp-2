package com.nyp2.sosyalmedya.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.Like;
import com.nyp2.sosyalmedya.entities.Post;
import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.LikeRepository;
import com.nyp2.sosyalmedya.repositories.PostRepository;
import com.nyp2.sosyalmedya.repositories.UserRepository;
import com.nyp2.sosyalmedya.requests.LikeCreateRequest;
import com.nyp2.sosyalmedya.responses.PostResponse;
import com.nyp2.sosyalmedya.responses.UserResponse;

@Service
public class LikeService {

    private LikeRepository likeRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public LikeService(LikeRepository likeRepository, UserRepository userRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public boolean isLiked(Long postId, Long userId) {
        return likeRepository.existsByUserIdAndPostId(userId, postId);
    }

    public List<PostResponse> getAllLikes(Optional<Long> postId, Optional<Long> userId) {
        if (postId.isPresent()) {
            List<Like> likes = likeRepository.findByPostId(postId.get());
            return likes.stream()
                .map(this::convertToLikeResponse)
                .collect(Collectors.toList());
        } else if (userId.isPresent()) {
            List<Like> likes = likeRepository.findByUserId(userId.get());
            return likes.stream()
                .map(this::convertToLikeResponse)
                .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public Like createLike(LikeCreateRequest likeCreateRequest) {
        Optional<User> user = userRepository.findById(likeCreateRequest.getUserId());
        Optional<Post> post = postRepository.findById(likeCreateRequest.getPostId());
        if (!user.isPresent() || !post.isPresent()) {
            return null;
        }
        Like newLike = new Like();
        newLike.setPost(post.get());
        newLike.setUser(user.get());
        return likeRepository.save(newLike); 
    }

    public void deleteLike(Long postId, Long userId) {
        Like like = likeRepository.findByUserIdAndPostId(userId, postId);
        if (like == null) {
            return;
        }
        likeRepository.deleteById(like.getId());
    }

    private PostResponse convertToLikeResponse(Like like) {
        UserResponse userResponse = new UserResponse(
            like.getPost().getUser().getId(), 
            like.getPost().getUser().getUsername(),
            like.getPost().getUser().getFollowers().size(),
            like.getPost().getUser().getFollows().size()
        );
        PostResponse postResponse = new PostResponse(
            like.getPost().getId(), 
            userResponse, 
            like.getPost().getTextContent(), 
            like.getPost().getCreationDate(),
            like.getPost().getLikes().size(),
            like.getPost().getComments().size()
        );
        return postResponse;

    }

}
