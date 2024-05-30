package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/users")
    public String addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUserID(userDTO.getUserID());
        user.setUsername(userDTO.getUsername());
        // Add other fields if needed

        userService.saveUser(user);
        return "User added!";
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{userID}")
    public User findUserByID(@PathVariable long userID) {
        return userService.getUserById(userID).orElse(null);
    }

    @GetMapping(path = "/users/username/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @DeleteMapping(path = "/users/{userID}")
    public void deleteUserById(@PathVariable long userID) {
        userService.deleteUser(userID);
    }
}
