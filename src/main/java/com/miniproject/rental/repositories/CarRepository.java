package com.miniproject.rental.repositories;

import com.miniproject.rental.enums.Segment;
import com.miniproject.rental.models.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {
    List<Car> findByBrand(String brand);

    List<Car> findBySegment(Segment segment);

    List<Car> findAllByOrderByBrandAsc();

    @Query(value = "SELECT * FROM cars WHERE id NOT IN (SELECT car_id FROM rents WHERE return_at IS NULL)", nativeQuery = true)
    List<Car> findAvailables();
}