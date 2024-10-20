package com.example.demo.controllerTest;

import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeaderboardApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testRegisterUser() {
        User newUser = new User("1", "Coder123");
        ResponseEntity<User> response = restTemplate.postForEntity("/users", newUser, User.class);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetUser() {
        ResponseEntity<User> response = restTemplate.getForEntity("/users/1", User.class);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }
}
