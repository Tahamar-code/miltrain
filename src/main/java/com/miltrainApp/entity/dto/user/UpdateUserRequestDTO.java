package com.miltrainApp.entity.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequestDTO {

    private Long id;

    private String name;

    private Integer age;

    private String password;
}
