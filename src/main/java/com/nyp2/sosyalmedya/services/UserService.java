package com.nyp2.sosyalmedya.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.UserRepository;
import com.nyp2.sosyalmedya.requests.UserCreateRequest;
import com.nyp2.sosyalmedya.requests.UserUpdateRequest;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User createUser(UserCreateRequest userCreateRequest) {
        System.out.println(userCreateRequest.getUsername());
        User user = userRepository.findByUsername(userCreateRequest.getUsername());
        if (user != null) {
            return null;
        }
        User newUser = new User();
        newUser.setUsername(userCreateRequest.getUsername());
        newUser.setPassword(userCreateRequest.getPassword());
        return userRepository.save(newUser);
    }

    public User updateUser(Long userId, UserUpdateRequest userUpdateRequest) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            return null;
        }
        User foundUser = user.get();
        foundUser.setUsername(userUpdateRequest.getUsername());
        foundUser.setPassword(userUpdateRequest.getPassword());
        return userRepository.save(foundUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
