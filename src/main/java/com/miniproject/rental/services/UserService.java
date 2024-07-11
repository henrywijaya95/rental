package com.miniproject.rental.services;

import com.miniproject.rental.dtos.UserDTO;
import com.miniproject.rental.exceptions.RentalCarException;
import com.miniproject.rental.mappers.UserMapper;
import com.miniproject.rental.models.User;
import com.miniproject.rental.repositories.UserRepository;
import com.miniproject.rental.utilities.Constants;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Throwable.class)
    public User signIn(String code, String password) {
        Optional<User> userFound = userRepository.findByCodeAndPassword(code, password);

        if (userFound.isPresent()) {
            throw new RentalCarException(HttpStatus.UNAUTHORIZED, "User not found in database", "Invalid credentials");
        }

        return userRepository.save(userFound.get());
    }

    @Transactional(rollbackFor = Throwable.class)
    public User signOut(Long id) {
        User user = getById(id);

        return userRepository.save(user);
    }

    @Transactional(rollbackFor = Throwable.class)
    public User create(User newUser) {
        return userRepository.save(newUser);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<User> getByCodeOrName(String code, String name) {
        return userRepository.findByCodeOrName(code, name);
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RentalCarException(HttpStatus.NOT_FOUND, Constants.HEADER_USER_NOT_FOUND, "The provided id: " + id + " does not exists in database."));
    }

    @Transactional(rollbackFor = Throwable.class)
    public User update(UserDTO body) {
        return getById(body.getId());
    }
}