package com.miniproject.rental.controllers;

import com.miniproject.rental.dtos.UserDTO;
import com.miniproject.rental.mappers.UserMapper;
import com.miniproject.rental.models.User;
import com.miniproject.rental.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.miniproject.rental.utilities.Constants.*;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "return create", authorizations = { @Authorization(value = "jwtToken") })
    @PostMapping(value = "create")
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserDTO body) {
        User newUser = userMapper.toModel(body);
        User createdUser = userService.create(newUser);
        UserDTO createdUserDTO = userMapper.toDto(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO);
    }

    @ApiOperation(value = "return sign in", authorizations = { @Authorization(value = "jwtToken") })
    @PutMapping(value = "signin")
    public ResponseEntity<UserDTO> signIn(@RequestParam(value = "code") String code, @RequestParam(value = "password") String password) {
        User user = userService.signIn(code, password);
        UserDTO userDTO = userMapper.toDto(user);

        return ResponseEntity.ok().body(userDTO);
    }

    @ApiOperation(value = "return sign out", authorizations = { @Authorization(value = "jwtToken") })
    @PutMapping(value = "signout")
    public ResponseEntity<UserDTO> signOut(@PathVariable(value = "id") Long id) {
        User user = userService.signOut(id);
        UserDTO userDTO = userMapper.toDto(user);

        return ResponseEntity.ok().body(userDTO);
    }

    @ApiOperation(value = "return all", authorizations = { @Authorization(value = "jwtToken") })
    @GetMapping(value = "all")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<User> users = userService.getAll();
        List<UserDTO> usersDTO = userMapper.toDTOs(users);

        return usersDTO.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(usersDTO);
    }

    @ApiOperation(value = "return all by code and name", authorizations = { @Authorization(value = "jwtToken") })
    @GetMapping(value = "by-code-name")
    public ResponseEntity<List<UserDTO>> getByCodeOrName(@RequestParam(value = CODE) String code, @RequestParam(value = NAME) String name){
        List<User> users = userService.getByCodeOrName(code, name);
        List<UserDTO> usersDTO = userMapper.toDTOs(users);

        return usersDTO.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(usersDTO);
    }

    @ApiOperation(value = "return all by id", authorizations = { @Authorization(value = "jwtToken") })
    @GetMapping(value = "by-id")
    public ResponseEntity<UserDTO> getById(@RequestParam(value = ID) Long id) {
        User user = userService.getById(id);
        UserDTO userDTO = userMapper.toDto(user);

        return ResponseEntity.ok().body(userDTO);
    }

    @ApiOperation(value = "return update", authorizations = { @Authorization(value = "jwtToken") })
    @PutMapping(value = "update")
    public ResponseEntity<UserDTO> update(@RequestBody @Valid UserDTO body) {
        User updatedUser = userService.update(body);
        UserDTO updatedUserDTO = userMapper.toDto(updatedUser);

        return ResponseEntity.ok().body(updatedUserDTO);
    }
}