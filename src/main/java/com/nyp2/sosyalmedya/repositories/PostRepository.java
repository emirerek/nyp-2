package com.nyp2.sosyalmedya.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nyp2.sosyalmedya.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    
    List<Post> findAllByUserId(Long userId);

    @Query("SELECT p FROM Post p WHERE p.user IN (SELECT f.followedUser FROM Follower f WHERE f.followingUser.id = :userId) ORDER BY p.creationDate DESC")
    List<Post> findLatestPostsByFollowedUsers(@Param("userId") Long userId);
    
}
