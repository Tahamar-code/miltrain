package com.miltrainApp.userService;


import com.miltrainApp.utils.AppUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class User {

    private final UUID id;

    @Setter
    private String name;

    @Setter
    private Integer age;

    public User(String name, Integer age) {
        this.id = AppUtils.generateUserId();
        this.name = name;
        this.age = age;
    }
}
