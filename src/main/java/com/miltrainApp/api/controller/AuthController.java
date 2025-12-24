package com.miltrainApp.api.controller;


import com.miltrainApp.model.LoginRequest;
import com.miltrainApp.model.User;
import com.miltrainApp.security.JwtUtil;
import com.miltrainApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userService.authenticate(request.getLogin(), request.getPassword());


        String token = jwtUtil.generateToken(user.getLogin());

        return ResponseEntity.ok(Map.of("token", "Bearer " + token));
    }
}
