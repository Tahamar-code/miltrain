package com.miltrainApp.service;

import com.miltrainApp.entity.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    List<User> getUsers();

    User updateUser(User userForUpdate);

    void deleteUserById(Long userIdForDelete);
}
