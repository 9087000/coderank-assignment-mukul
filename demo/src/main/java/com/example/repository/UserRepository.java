package com.example.repository;


import com.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByOrderByScoreDesc();  // Custom method to sort by score
}
