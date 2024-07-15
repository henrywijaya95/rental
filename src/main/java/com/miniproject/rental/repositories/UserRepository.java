package com.miniproject.rental.repositories;

import com.miniproject.rental.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Optional<User> findByCodeAndPassword(String code, String password);

    List<User> findByCodeOrName(String code, String name);
}