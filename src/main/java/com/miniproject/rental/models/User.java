package com.miniproject.rental.models;

import com.miniproject.rental.enums.Role;
import com.miniproject.rental.enums.converters.RoleConverter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private UUID token;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true, updatable = false)
    private String code;
    private String password;

    @Convert(converter = RoleConverter.class)
    private Role role;
}