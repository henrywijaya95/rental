package com.miniproject.rental.mappers;

import com.miniproject.rental.dtos.UserDTO;
import com.miniproject.rental.models.User;

import jakarta.validation.Valid;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toModel(@Valid UserDTO userDTO);

    UserDTO toDto(User user);

    List<UserDTO> toDTOs(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "token", ignore = true)
    @Mapping(target = "code", ignore = true)
    @Mapping(target = "password", ignore = true)
    User partialUpdate(UserDTO userDTO, @MappingTarget User user);
}