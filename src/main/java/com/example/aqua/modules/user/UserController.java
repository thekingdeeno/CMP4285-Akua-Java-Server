package com.example.aqua.modules.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.aqua.shared.dtos.ApiResponse;
import com.example.aqua.modules.user.dtos.CreateUserReq;
import com.example.aqua.shared.utils.Response;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

        @PostMapping("/signup")
        public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserReq body) {
            Map<String, Object> data = userService.createUser(body);
            return ResponseEntity.ok(new ApiResponse(data));
        }


        @PostMapping("/login")
        public ResponseEntity<ApiResponse> login(@RequestBody CreateUserReq body) {
            Map<String, Object> data = userService.login(body);
            return Response.generic(data);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id) {
            Map<String, Object> data = userService.getUserById(id);
            return Response.generic(data);
        }
}