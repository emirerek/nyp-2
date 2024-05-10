package com.nyp2.sosyalmedya.services;

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

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public List<Comment> getPostComments(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> getUserComments(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    public Comment createComment(CommentCreateRequest commentCreateRequest) {
        User user = userRepository.findById(commentCreateRequest.getUserId()).orElse(null);
        Post post = postRepository.findById(commentCreateRequest.getPostId()).orElse(null);
        if (user != null && post != null) {
            Comment newComment = new Comment();
            newComment.setUser(user);
            newComment.setPost(post);
            newComment.setText(commentCreateRequest.getText());
            return commentRepository.save(newComment);
        } else {
            return null;
        }
    }

    public Comment updateComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(commentUpdateRequest.getText());
            return commentRepository.save(commentToUpdate);
        } else {
            return null;
        }
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
    
}
