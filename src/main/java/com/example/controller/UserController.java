package com.example.controller;

import com.example.models.UserDTO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired UserService userService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/user")
    public void createUser(@RequestBody UserDTO user) {
        userService.createUser(user);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/user")
    public UserDTO getUser(@RequestParam String userId) {
        return userService.getUser(userId);
    }
}
