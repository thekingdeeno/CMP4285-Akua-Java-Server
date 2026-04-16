package com.example.aqua.modules.user;

import org.springframework.stereotype.Service;

import com.example.aqua.modules.user.dtos.CreateUserReq;
import java.util.Map;
import java.util.HashMap;
import com.example.aqua.models.User;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, Object> createUser(CreateUserReq body){
        System.out.println("Creating user: " + body.getName());
        User user = new User();
        user.setName(body.getName());
        user.setPassword(body.getPassword());
        user.setEmail(body.getEmail());
        User query = userRepository.save(user);

        System.out.println("User created with ID: " + user.getId());

        Map<String, Object> data = new HashMap<>();
        data.put("status", true);
        data.put("message", "User created successfully");
        data.put("data", query);
        return data;
    }

    public Map<String, Object> getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        Map<String, Object> data = new HashMap<>();
        if (user != null) {
            data.put("status", true);
            data.put("data", user);
            data.put("message", "User retrieved successfully");
        } else {
            data.put("status", false);
            data.put("message", "User not found");
        }
        return data;
    }
}