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
    @JoinColumn(name = "followed")
    private User followed;

    @ManyToOne
    @JoinColumn(name = "follower")
    private User follower;

    public Long getId() {
        return this.id;
    }

    public User getFollowed() {
        return this.followed;
    }

    public User getFollower() {
        return this.follower;
    }

    public void setFollowed(User user) {
        this.followed = user;
    }

    public void setFollower(User user) {
        this.follower = user;
    }

}
