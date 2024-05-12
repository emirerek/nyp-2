package com.nyp2.sosyalmedya.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.Comment;
import com.nyp2.sosyalmedya.entities.Post;
import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.CommentRepository;
import com.nyp2.sosyalmedya.repositories.PostRepository;
import com.nyp2.sosyalmedya.repositories.UserRepository;
import com.nyp2.sosyalmedya.requests.CommentCreateRequest;
import com.nyp2.sosyalmedya.requests.CommentUpdateRequest;

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

    public List<Comment> getAllComments(Optional<Long> postId, Optional<Long> userId) {
        if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
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
        newComment.setTextContent(commentCreateRequest.getText());
        newComment.setCreationDate(LocalDateTime.now());
        return commentRepository.save(newComment);
    }

    public Comment updateComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (!comment.isPresent()) {
            return null;
        }
        Comment commentToUpdate = comment.get();
        commentToUpdate.setTextContent(commentUpdateRequest.getText());
        return commentRepository.save(commentToUpdate);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
    
}
