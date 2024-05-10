package com.nyp2.sosyalmedya.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyp2.sosyalmedya.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    List<Comment> findByUserId(Long userId);

    List<Comment> findByPostId(Long postId);

}
