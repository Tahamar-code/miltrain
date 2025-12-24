package com.miltrainApp.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequestDTO {

    private String name;

    private Integer age;

    private String login;

    private String password;
}
