package com.uep.wap.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uep.wap.model.User;
import com.uep.wap.repository.UserRepository;
import java.util.List;
import java.util.Optional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional <User> getUserById(Long id) { return userRepository.findById(id);
    }}




    // Additional methods as needed

