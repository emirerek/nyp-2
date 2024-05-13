package com.nyp2.sosyalmedya.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.Comment;
import com.nyp2.sosyalmedya.entities.Post;
import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.CommentRepository;
import com.nyp2.sosyalmedya.repositories.PostRepository;
import com.nyp2.sosyalmedya.repositories.UserRepository;
import com.nyp2.sosyalmedya.requests.CommentCreateRequest;
import com.nyp2.sosyalmedya.requests.CommentUpdateRequest;
import com.nyp2.sosyalmedya.responses.CommentResponse;
import com.nyp2.sosyalmedya.responses.UserResponse;

@Service
public class CommentService {
    
    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<CommentResponse> getAllComments(Optional<Long> postId, Optional<Long> userId) {
        if (postId.isPresent()) {
            List<Comment> comments = commentRepository.findByPostId(postId.get());
            return comments.stream()
                .map(this::convertToCommentResponse)
                .collect(Collectors.toList());
        } else if (userId.isPresent()) {
            List<Comment> comments = commentRepository.findByUserId(userId.get());
            return comments.stream()
                .map(this::convertToCommentResponse)
                .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public Comment createComment(CommentCreateRequest commentCreateRequest) {
        User user = userRepository.findById(commentCreateRequest.getUserId()).orElse(null);
        Post post = postRepository.findById(commentCreateRequest.getPostId()).orElse(null);
        if (user == null || post == null) {
            return null;
        }
        Comment newComment = new Comment();
        newComment.setUser(user);
        newComment.setPost(post);
        newComment.setTextContent(commentCreateRequest.getTextContent());
        newComment.setCreationDate(LocalDateTime.now());
        return commentRepository.save(newComment);
    }

    public Comment updateComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (!comment.isPresent()) {
            return null;
        }
        Comment commentToUpdate = comment.get();
        commentToUpdate.setTextContent(commentUpdateRequest.getTextContent());
        return commentRepository.save(commentToUpdate);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
    
    private CommentResponse convertToCommentResponse(Comment comment) {
        UserResponse userResponse = new UserResponse(
            comment.getUser().getId(), 
            comment.getUser().getUsername(),
            comment.getUser().getFollowers().size(),
            comment.getUser().getFollows().size()
        );
        return new CommentResponse(
            comment.getId(), 
            userResponse, 
            comment.getTextContent(), 
            comment.getCreationDate()
        );
    }

}
