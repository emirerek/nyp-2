package com.nyp2.sosyalmedya.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "followers")
public class Follower {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "followingUser")
    private User followingUser;

    @ManyToOne
    @JoinColumn(name = "followedUser")
    private User followedUser;

    public Long getId() {
        return this.id;
    }

    public User getFollowingUser() {
        return this.followingUser;
    }

    public User getFollowedUser() {
        return this.followedUser;
    }

    public void setFollowedUser(User followedUser) {
        this.followedUser = followedUser;
    }

    public void setFollowingUser(User followingUser) {
        this.followingUser = followingUser;
    }

}
