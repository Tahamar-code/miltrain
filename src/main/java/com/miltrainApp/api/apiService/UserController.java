package com.miltrainApp.api.apiService;


import com.miltrainApp.model.User;
import com.miltrainApp.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getUsers(){
        return UserService.getUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        UserService.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        UserService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUserById(@RequestParam("id") UUID idForDelete){
        UserService.deleteUserById(idForDelete);
    }
}
