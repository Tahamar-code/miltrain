package com.miltrainApp.api.service;

import com.miltrainApp.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserService {

    private final Map<Long, User> users = new HashMap<>();

    public User getUserById(Long id) {
        return users.get(id);
    }
    public List<User> getUsers() {
        return users.values()
                    .stream()
                    .toList();
    }

    public void createUser(User newUser) {
        users.put(newUser.getId(), newUser);
    }

    public void updateUser(User userForUpdate) {
        User existedUser = users.values()
                                .stream()
                                .filter(u -> u.getId()
                                              .equals(userForUpdate.getId()))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("User not found!"));

        existedUser.setName(userForUpdate.getName());
        existedUser.setAge(userForUpdate.getAge());
    }

    public void deleteUserById(Long userIdForDelete) {
        if (users.containsKey(userIdForDelete)) {
            users.remove(userIdForDelete);
        } else {
            throw new IllegalArgumentException("User not found!");
        }
    }
}
