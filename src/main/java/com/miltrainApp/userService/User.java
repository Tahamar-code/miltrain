package com.miltrainApp.userService;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private final Long id;
    private String name;
    Integer age;
}
