package com.nyp2.sosyalmedya.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Like> likes;

    @OneToMany(mappedBy = "followedUser")
    @JsonIgnore
    private List<Follower> followers;

    @OneToMany(mappedBy = "followingUser")
    @JsonIgnore
    private List<Follower> follows;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @JsonIgnore
    public List<Post> getPosts() {
        return posts;
    }

    @JsonIgnore
    public List<Comment> getComments() {
        return comments;
    }

    @JsonIgnore
    public List<Like> getLikes() {
        return likes;
    }

    @JsonIgnore
    public List<Follower> getFollowers() {
        return followers;
    }

    @JsonIgnore
    public List<Follower> getFollows() {
        return follows;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
}
