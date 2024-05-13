package com.nyp2.sosyalmedya.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nyp2.sosyalmedya.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
    
    List<Like> findByUserId(Long userId);

    List<Like> findByPostId(Long postId);

    Like findByUserIdAndPostId(Long userId, Long postId);

    boolean existsByUserIdAndPostId(Long userId, Long postId);

}
