package com.miltrainApp.api.controller;


import com.miltrainApp.entity.dto.user.UpdateUserRequestDTO;
import com.miltrainApp.entity.dto.user.UserResponseDTO;
import com.miltrainApp.service.UserService;
import com.miltrainApp.entity.dto.training.DeleteResponseDTO;
import com.miltrainApp.entity.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public Map<String, Object> getUsers() {
        List<User> users = userService.getUsers();
        return Map.of("users", users);
    }

    @PutMapping
    public UserResponseDTO updateUser(@RequestBody UpdateUserRequestDTO user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponseDTO> deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        DeleteResponseDTO deleteResponseDTO = new DeleteResponseDTO(String.format("User with id:%d is deleted!", userId));
        return ResponseEntity.ok(deleteResponseDTO);
    }
}
