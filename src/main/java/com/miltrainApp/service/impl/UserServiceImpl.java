package com.miltrainApp.service.impl;

import com.miltrainApp.entity.model.User;
import com.miltrainApp.exceptions.UserNotFoundException;
import com.miltrainApp.repository.UserRepository;
import com.miltrainApp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                             .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User userForUpdate) {
        User existedUser = userRepository.findById(userForUpdate.getId())
                                         .orElseThrow(() -> new UserNotFoundException("User not found!"));

        existedUser.setName(userForUpdate.getName());
        existedUser.setAge(userForUpdate.getAge());

        return userRepository.save(existedUser);
    }

    @Override
    public void deleteUserById(Long userIdForDelete) {
        User user = userRepository.findById(userIdForDelete)
                                  .orElseThrow(() -> new UserNotFoundException("User not found!"));
        userRepository.deleteById(userIdForDelete);
    }
}

