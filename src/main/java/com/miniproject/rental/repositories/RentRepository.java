package com.miniproject.rental.repositories;

import com.miniproject.rental.models.Rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long>, JpaSpecificationExecutor<Rent> {
    @Query(value = "SELECT * FROM rents WHERE user_id =:userId GROUP BY car_id", nativeQuery = true)
    List<Rent> findAllByClientId(@Param("userId") Long userId);
}