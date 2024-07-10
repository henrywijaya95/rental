package com.miniproject.rental.controllers;

import com.miniproject.rental.dtos.UserDTO;
import com.miniproject.rental.mappers.UserMapper;
import com.miniproject.rental.models.User;
import com.miniproject.rental.services.UserService;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping(value = "create/{" + TOKEN + "}")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<UserDTO> create(@PathVariable(value = TOKEN) UUID token, @RequestBody @Valid UserDTO body) {
        User newUser = userMapper.toModel(body);
        User createdUser = userService.create(token, newUser);
        UserDTO createdUserDTO = userMapper.toDto(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO);
    }

    @PutMapping(value = "signin")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<UserDTO> signIn(@RequestParam(value = "code") String code, @RequestParam(value = "password") String password) {
        User user = userService.signIn(code, password);
        UserDTO userDTO = userMapper.toDto(user);

        return ResponseEntity.ok().body(userDTO);
    }

    @PutMapping(value = "signout/{" + TOKEN + "}")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<UserDTO> signOut(@PathVariable(value = TOKEN) UUID token) {
        User user = userService.signOut(token);
        UserDTO userDTO = userMapper.toDto(user);

        return ResponseEntity.ok().body(userDTO);
    }

    @GetMapping(value = "all/{" + TOKEN + "}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<UserDTO>> getAll(@PathVariable(value = TOKEN) UUID token){
        List<User> users = userService.getAll(token);
        List<UserDTO> usersDTO = userMapper.toDTOs(users);

        return usersDTO.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping(value = "by-code-name/{" + TOKEN + "}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<UserDTO>> getByCodeOrName(@PathVariable(value = TOKEN) UUID token, @RequestParam(value = CODE) String code, @RequestParam(value = NAME) String name){
        List<User> users = userService.getByCodeOrName(token, code, name);
        List<UserDTO> usersDTO = userMapper.toDTOs(users);

        return usersDTO.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping(value = "by-id/{" + TOKEN + "}")
    @Transactional(readOnly = true)
    public ResponseEntity<UserDTO> getById(@PathVariable(value = TOKEN) UUID token, @RequestParam(value = ID) Long id) {
        User user = userService.getById(token, id);
        UserDTO userDTO = userMapper.toDto(user);

        return ResponseEntity.ok().body(userDTO);
    }

    @PutMapping(value = "update/{" + TOKEN + "}")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<UserDTO> update(@PathVariable(value = TOKEN) UUID token, @RequestBody @Valid UserDTO body) {
        User updatedUser = userService.update(token, body);
        UserDTO updatedUserDTO = userMapper.toDto(updatedUser);

        return ResponseEntity.ok().body(updatedUserDTO);
    }
}