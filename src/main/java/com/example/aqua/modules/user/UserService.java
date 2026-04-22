package com.example.aqua.modules.user;

import org.springframework.stereotype.Service;

import com.example.aqua.modules.user.dtos.CreateUserReq;
import java.util.Map;
import com.example.aqua.models.User;
import com.example.aqua.shared.utils.Response;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, Object> createUser(CreateUserReq body){
        try {
            System.out.println("Creating user: " + body.getName());
            User user = new User();
            user.setName(body.getName());
            user.setPassword(body.getPassword());
            user.setEmail(body.getEmail());
            User query = userRepository.save(user);

            System.out.println("User created with ID: " + user.getId());

            return Response.format(true, "User created successfully", query.toMap());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.format(false, "User creation failed: " + e.getMessage(), null);
        }
    }

    public Map<String, Object> login(CreateUserReq body) {
        try {
            User user = userRepository.findByEmail(body.getEmail());
            System.out.println("Attempting login for email: " + body.getEmail() + body.getPassword());

            if(user == null) {
                return Response.format(false, "Login failed: User not found", null);
            }
            if (user.getPassword() == null || !user.getPassword().equals(body.getPassword())) {
                return Response.format(false, "Login failed: Incorrect password", null);
            }
            System.out.println("Login successful for user: " + user.getEmail());
            return Response.format(true, "Login successful", user.toMap());
            
        } catch (Exception e) {
            e.printStackTrace();
            return Response.format(false, "Login failed: " + e.getMessage(), null);
        }
    }

    public Map<String, Object> getUserById(Long id) {
        try {
            User user = userRepository.findById(id).orElse(null);
            Map<String, Object> userMap = user.toMap();
            return Response.format(true, "User retrieved successfully", userMap);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.format(false, "Failed to retrieve user: " + e.getMessage(), null);
        }
    }
}