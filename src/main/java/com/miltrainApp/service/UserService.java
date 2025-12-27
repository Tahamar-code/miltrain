package com.miltrainApp.service;

import com.miltrainApp.entity.dto.user.UpdateUserRequestDTO;
import com.miltrainApp.entity.dto.user.UserResponseDTO;
import com.miltrainApp.entity.model.User;

import java.util.List;

public interface UserService {

    UserResponseDTO getUserById(Long id);

    List<User> getUsers();

    UserResponseDTO updateUser(UpdateUserRequestDTO userForUpdate);

    void deleteUserById(Long userIdForDelete);
}
