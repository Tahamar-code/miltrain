package com.miltrainApp.service;

import com.miltrainApp.entity.dto.user.RegisterRequestDTO;
import com.miltrainApp.entity.dto.user.UserResponseDTO;
import com.miltrainApp.entity.model.User;

public interface AuthService {

    User authenticate(String login, String rawPassword);

    UserResponseDTO register(RegisterRequestDTO registerRequest);
}
