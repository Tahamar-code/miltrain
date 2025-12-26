package com.miltrainApp.api.controller;


import com.miltrainApp.service.UserService;
import com.miltrainApp.entity.model.DeleteResponse;
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
    public User getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public Map<String, Object> getUsers() {
        List<User> users = userService.getUsers();
        return Map.of("users", users);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponse> deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        DeleteResponse deleteResponse = new DeleteResponse(String.format("User with id:%d is deleted!", userId));
        return ResponseEntity.ok(deleteResponse);
    }
}
