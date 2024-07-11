package com.miniproject.rental.dtos;

import com.miniproject.rental.enums.Role;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String code;

    private String password;

    private Role role;
}