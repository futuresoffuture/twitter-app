package com.example.controller;

import com.example.models.UserDTO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired UserService userService;

    @PostMapping("/user")
    public void createUser(@RequestBody UserDTO user) {
        userService.createUser(user);
    }

    @GetMapping("/user")
    public UserDTO getUser(@RequestParam String userId) {
        return userService.getUser(userId);
    }
}
