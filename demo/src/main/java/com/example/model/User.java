package com.example.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
import java.util.HashSet;

@Document(collection = "users")
public class User {
    @Id
    private String userId;
    private String username;
    private int score;
    private Set<String> badges = new HashSet<>();

    // Constructors, getters, and setters
    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
        this.score = 0;  // Default score
        this.badges = new HashSet<>();  // Default empty badges
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Set<String> getBadges() {
        return badges;
    }

    public void addBadge(String badge) {
        this.badges.add(badge);
    }
}
