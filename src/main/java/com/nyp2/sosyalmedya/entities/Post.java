package com.nyp2.sosyalmedya.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
 
    @Column(columnDefinition = "text")
    private String textContent;

    private LocalDateTime creationDate;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTextContent() {
        return textContent;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<Like> getLikes() {
        return this.likes;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

}
