package com.miltrainApp.api.service;

import com.miltrainApp.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class UserService {

    private static final Map<UUID, User> users = new HashMap<>();

    public static List<User> getUsers() {
        return users.values()
                    .stream()
                    .toList();
    }

    public static void createUser(User newUser) {
        users.put(newUser.getId(), newUser);
    }

    public static void updateUser(User userForUpdate) {
        User existedUser = users.values()
                                .stream()
                                .filter(u -> u.getId()
                                              .equals(userForUpdate.getId()))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("User not found!"));

        existedUser.setName(userForUpdate.getName());
        existedUser.setAge(userForUpdate.getAge());
    }

    public static void deleteUserById(UUID userIdForDelete) {
        if (users.containsKey(userIdForDelete)) {
            users.remove(userIdForDelete);
        } else {
            throw new IllegalArgumentException("User not found!");
        }
    }
}
