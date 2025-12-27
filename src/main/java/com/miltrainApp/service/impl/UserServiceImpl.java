package com.miltrainApp.service.impl;

import com.miltrainApp.entity.dto.user.UpdateUserRequestDTO;
import com.miltrainApp.entity.dto.user.UserResponseDTO;
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
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new UserNotFoundException("User not found!"));

        return new UserResponseDTO.Builder().id(user.getId())
                                            .name(user.getName())
                                            .age(user.getAge())
                                            .login(user.getLogin())
                                            .role(user.getRole())
                                            .build();

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponseDTO updateUser(UpdateUserRequestDTO userForUpdate) {
        User existedUser = userRepository.findById(userForUpdate.getId())
                                         .orElseThrow(() -> new UserNotFoundException("User not found!"));

        existedUser.setName(userForUpdate.getName());
        existedUser.setAge(userForUpdate.getAge());

        User userAfterUpdate = userRepository.save(existedUser);

        return new UserResponseDTO.Builder().id(userAfterUpdate.getId())
                                            .name(userAfterUpdate.getName())
                                            .age(userAfterUpdate.getAge())
                                            .login(userAfterUpdate.getLogin())
                                            .role(userAfterUpdate.getRole())
                                            .build();
    }

    @Override
    public void deleteUserById(Long userIdForDelete) {
        User user = userRepository.findById(userIdForDelete)
                                  .orElseThrow(() -> new UserNotFoundException("User not found!"));
        userRepository.deleteById(userIdForDelete);
    }
}

