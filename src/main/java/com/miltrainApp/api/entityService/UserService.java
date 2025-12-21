package com.miltrainApp.api.entityService;

import com.miltrainApp.exceptions.UserNotFoundException;
import com.miltrainApp.model.User;
import com.miltrainApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                             .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUser(User newUser) {
        userRepository.save(newUser);
    }

    public User updateUser(User userForUpdate) {
        User existedUser = userRepository.findById(userForUpdate.getId())
                                         .orElseThrow(() -> new UserNotFoundException("User not found!"));

        existedUser.setName(userForUpdate.getName());
        existedUser.setAge(userForUpdate.getAge());

        return userRepository.save(existedUser);
    }

    public void deleteUserById(Long userIdForDelete) {
        User user = userRepository.findById(userIdForDelete)
                                  .orElseThrow(() -> new UserNotFoundException("User not found!"));
        userRepository.deleteById(userIdForDelete);
    }
}

