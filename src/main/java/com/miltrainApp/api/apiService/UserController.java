package com.miltrainApp.api.apiService;


import com.miltrainApp.api.entityService.UserService;
import com.miltrainApp.model.DeleteResponse;
import com.miltrainApp.model.User;
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

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        userService.createUser(newUser);
        return userService.getUserById(newUser.getId());
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
