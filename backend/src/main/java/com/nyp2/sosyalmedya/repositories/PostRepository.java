package com.nyp2.sosyalmedya.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyp2.sosyalmedya.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    
    List<Post> findAllByUserId(Long userId);
    
}
