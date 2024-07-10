package com.miniproject.rental.repositories;

import com.miniproject.rental.enums.Role;
import com.miniproject.rental.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Boolean existsByCodeAndName(String code, String name);

    Optional<User> findByCodeAndPassword(String code, String password);

    Optional<User> findByToken(UUID token);

    Integer countByRole(Role role);

    List<User> findByCodeOrName(String code, String name);
}