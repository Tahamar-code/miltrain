package com.miltrainApp.userService;


import com.miltrainApp.utils.AppUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class User {
    private final UUID id;
    private String name;
    private Integer age;

    public User(String name, Integer age){
        this.id = AppUtils.generateUserId();
        this.name = name;
        this.age = age;
    }
}
