package com.miltrainApp.entity.dto.user;

import com.miltrainApp.utils.Role;
import lombok.Getter;

@Getter
public class UserResponseDTO {

    private Long id;

    private String login;

    private String name;

    private Integer age;

    private Role role;

    UserResponseDTO() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final UserResponseDTO dto = new UserResponseDTO();

        public Builder id(Long id) {
            dto.id = id;
            return this;
        }

        public Builder login(String login) {
            dto.login = login;
            return this;
        }

        public Builder name(String name) {
            dto.name = name;
            return this;
        }

        public Builder age(Integer age) {
            dto.age = age;
            return this;
        }

        public Builder role(Role role) {
            dto.role = role;
            return this;
        }

        public UserResponseDTO build() {
            return dto;
        }
    }
}
