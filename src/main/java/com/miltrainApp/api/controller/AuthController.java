package com.miltrainApp.api.controller;

import com.miltrainApp.entity.dto.auth.LoginResponseDTO;
import com.miltrainApp.entity.dto.user.RegisterRequestDTO;
import com.miltrainApp.entity.dto.user.UserResponseDTO;
import com.miltrainApp.entity.model.LoginRequest;
import com.miltrainApp.entity.model.User;
import com.miltrainApp.security.JwtUtil;
import com.miltrainApp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = authService.authenticate(request.getLogin(), request.getPassword());

        String token = jwtUtil.generateToken(user.getId(), user.getLogin(), user.getRole().name());

        return ResponseEntity.ok(new LoginResponseDTO("Bearer " + token));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterRequestDTO registerRequest) {
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}
