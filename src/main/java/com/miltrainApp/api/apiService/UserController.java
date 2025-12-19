package com.miltrainApp.api.apiService;


import com.miltrainApp.userService.User;
import com.miltrainApp.userService.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
