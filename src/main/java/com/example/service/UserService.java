package com.example.service;

import com.example.entities.User;
import com.example.models.UserDTO;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public void createUser(UserDTO userDto) {

       User user = new User();
       user.setUserId(userDto.getUserId());
       user.setFirstName(userDto.getFirstName());
       user.setLastName(userDto.getLastName());
       user.setPassword(userDto.getPassword());

       userRepository.saveUser(user);
    }

    public UserDTO getUser(String userId) {
        User user = userRepository.getUserById(userId);
        return new UserDTO(user.getFirstName(), user.getLastName(), null, user.getUserId());
    }

}
