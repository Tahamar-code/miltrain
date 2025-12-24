package com.miltrainApp.service;

import com.miltrainApp.exceptions.UserNotFoundException;
import com.miltrainApp.model.User;
import com.miltrainApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                             .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUser(User newUser) {
        newUser.setPasswordHash(passwordEncoder.encode(newUser.getPasswordHash()));
        userRepository.save(newUser);
    }

    public User updateUser(User userForUpdate) {
        User existedUser = userRepository.findById(userForUpdate.getId())
                                         .orElseThrow(() -> new UserNotFoundException("User not found!"));

        existedUser.setName(userForUpdate.getName());
        existedUser.setAge(userForUpdate.getAge());

        return userRepository.save(existedUser);
    }

    public void deleteUserById(Long userIdForDelete) {
        User user = userRepository.findById(userIdForDelete)
                                  .orElseThrow(() -> new UserNotFoundException("User not found!"));
        userRepository.deleteById(userIdForDelete);
    }


    public User authenticate(String login, String rawPassword){
        User user = userRepository.findByLogin(login).orElseThrow(() ->
                                                                          new RuntimeException("Invalid credentials"));

        if(!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials #2");
        }

        return user;
    }
}

