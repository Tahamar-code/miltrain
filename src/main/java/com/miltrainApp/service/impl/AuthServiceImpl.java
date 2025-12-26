package com.miltrainApp.service.impl;

import com.miltrainApp.entity.dto.user.RegisterRequestDTO;
import com.miltrainApp.entity.dto.user.UserResponseDTO;
import com.miltrainApp.entity.model.User;
import com.miltrainApp.exceptions.LoginAlreadyExistsException;
import com.miltrainApp.repository.UserRepository;
import com.miltrainApp.service.AuthService;
import com.miltrainApp.utils.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Role DEFAULT_ROLE = Role.USER;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User authenticate(String login, String rawPassword) {
        User user = userRepository.findByLogin(login)
                                  .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials #2");
        }

        return user;
    }

    @Override
    public UserResponseDTO register(RegisterRequestDTO registerRequest) {
        if (userRepository.existsByLogin(registerRequest.getLogin())) {
            throw new LoginAlreadyExistsException("User already exists!");
        }

        User user = new User();
        user.setName(registerRequest.getName());
        user.setAge(registerRequest.getAge());
        user.setLogin(registerRequest.getLogin());
        user.setPasswordHash(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(DEFAULT_ROLE);

        User savedUser = userRepository.save(user);
        return new UserResponseDTO.Builder().id(savedUser.getId())
                                            .login(savedUser.getLogin())
                                            .name(savedUser.getName())
                                            .age(savedUser.getAge())
                                            .role(savedUser.getRole())
                                            .build();
    }
}