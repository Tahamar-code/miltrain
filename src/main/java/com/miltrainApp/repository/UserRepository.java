package com.miltrainApp.repository;

import com.miltrainApp.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    Boolean existsByLogin(String login);
}
