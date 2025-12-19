package com.miltrainApp.userService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class UserService {
    private static final Map<UUID, User> users = new HashMap<>();


    public static List<User> getUsers(){
        return users.values().stream().toList();
    }

    public static void createUser(User newUser){

        log.info("Trying to create user with id {}", newUser.getId());
        if (users.containsKey(newUser.getId())){
            log.error("User with id {} already exists!", newUser.getId());
            throw new IllegalArgumentException("User with such Id already exists!");
        }
        users.put(newUser.getId(), newUser);
        log.info("User with id {} created successfully", newUser.getId());
    }

}
