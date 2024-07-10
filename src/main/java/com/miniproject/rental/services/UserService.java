package com.miniproject.rental.services;

import com.miniproject.rental.dtos.UserDTO;
import com.miniproject.rental.enums.Role;
import com.miniproject.rental.exceptions.RentalCarException;
import com.miniproject.rental.mappers.UserMapper;
import com.miniproject.rental.models.User;
import com.miniproject.rental.repositories.UserRepository;
import com.miniproject.rental.utilities.Constants;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User signIn(String code, String password) {
        Optional<User> userFound = userRepository.findByCodeAndPassword(code, password);

        if (userFound.isEmpty()) {
            throw new RentalCarException(HttpStatus.UNAUTHORIZED, "User not found in database", "Invalid credentials");
        }

        userFound.get().setToken(UUID.randomUUID());

        return userRepository.save(userFound.get());
    }

    public User signOut(UUID token) {
        User user = getByToken(token);
        user.setToken(null);

        return userRepository.save(user);
    }

    public User getByToken(UUID token) {
        return userRepository.findByToken(token).orElseThrow(() -> new RentalCarException(HttpStatus.FORBIDDEN,
                Constants.HEADER_FORBIDDEN, "You cannot perform the action with the provided token: " + token));
    }

    public User create(UUID token, User newUser) {
        User signedUser = getByToken(token);

        if (signedUser.getRole().equals(Role.EMPLOYEE)) {
            newUser.setRole(Role.CLIENT);
            newUser.setPassword(null);
        }

        newUser.setCode(generateCode(newUser.getRole() != null ? newUser.getRole() : Role.CLIENT));

        return userRepository.save(newUser);
    }

    private String generateCode(Role role) {
        DecimalFormat decimalFormat = new DecimalFormat("000");

        return switch (role) {
            case CLIENT -> "CLI_" + (decimalFormat.format(userRepository.countByRole(Role.CLIENT) + 1));
            case EMPLOYEE -> "EMP_" + (decimalFormat.format(userRepository.countByRole(Role.EMPLOYEE) + 1));
            case MANAGER -> "MAN_" + (decimalFormat.format(userRepository.countByRole(Role.MANAGER) + 1));
        };
    }

    public List<User> getAll(UUID token) {
        getByToken(token);

        return userRepository.findAll();
    }

    public List<User> getByCodeOrName(UUID token, String code, String name) {
        getByToken(token);

        return userRepository.findByCodeOrName(code, name);
    }

    public User getById(UUID token, Long id) {
        if (token != null) {
            getByToken(token);
        }

        return userRepository.findById(id).orElseThrow(() -> new RentalCarException(HttpStatus.NOT_FOUND, Constants.HEADER_USER_NOT_FOUND, "The provided id: " + id + " does not exists in database."));
    }

    public User update(UUID token, UserDTO body) {
        User userWhoWillUpdate = getByToken(token);
        User userWhoWillBeUpdated = getById(null, body.getId());

        if (userWhoWillUpdate.getRole().equals(Role.EMPLOYEE) && !userWhoWillBeUpdated.getRole().equals(Role.CLIENT)) {
            throw new RentalCarException(HttpStatus.FORBIDDEN, "Action not allowed", "You do not have enough permitioms to perform this operation.");
        }

        userWhoWillBeUpdated = userMapper.partialUpdate(body, userWhoWillBeUpdated);

        return userWhoWillBeUpdated;
    }
}