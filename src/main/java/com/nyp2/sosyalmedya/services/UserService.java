package com.nyp2.sosyalmedya.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.UserRepository;
import com.nyp2.sosyalmedya.requests.UserCreateRequest;
import com.nyp2.sosyalmedya.requests.UserUpdateRequest;
import com.nyp2.sosyalmedya.responses.UserResponse;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        return this.convertToUserResponse(user);
    }

    public User createUser(UserCreateRequest userCreateRequest) {
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

    private UserResponse convertToUserResponse(User user) {
        return new UserResponse(
            user.getId(), 
            user.getUsername(),
            user.getFollowers().size(),
            user.getFollows().size()
        );
    }

}
