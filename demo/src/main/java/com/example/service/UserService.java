package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create or register a user
    public User registerUser(User user) {
        user.setScore(0);  // Initial score
        return userRepository.save(user);
    }

    // Retrieve all users sorted by score
    public List<User> getAllUsers() {
        return userRepository.findAllByOrderByScoreDesc();
    }

    // Retrieve a specific user by userId
    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    // Update user score and assign badges
    public User updateScore(String userId, int score) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setScore(score);
            assignBadges(user);
            return userRepository.save(user);
        }
        throw new RuntimeException("User not found");
    }

    // Delete user
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    // Assign badges based on score
    private void assignBadges(User user) {
        user.getBadges().clear();  // Reset badges
        int score = user.getScore();
        if (score >= 1 && score < 30) {
            user.addBadge("Code Ninja");
        } else if (score >= 30 && score < 60) {
            user.addBadge("Code Champ");
        } else if (score >= 60 && score <= 100) {
            user.addBadge("Code Master");
        }
    }
}
