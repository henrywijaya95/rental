package com.miniproject.rental.mappers.utils;

import com.miniproject.rental.dtos.CarDTO;
import com.miniproject.rental.exceptions.RentalCarException;
import com.miniproject.rental.mappers.CarMapper;
import com.miniproject.rental.models.Car;
import com.miniproject.rental.models.User;
import com.miniproject.rental.repositories.CarRepository;
import com.miniproject.rental.repositories.UserRepository;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentMapperUtil {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    private CarMapper carMapper;

    @Named("findUser")
    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RentalCarException("User with the provided id: " + id + "not found."));
    }

    @Named("findCar")
    public Car getCarById(Long id) {
        return this.carRepository.findById(id).orElseThrow(() -> new RentalCarException("Car with the provided id: " + id + "not found."));
    }

    @Named("fromCartoCarDTO")
    public CarDTO toCarDTO(Car car) {
        return carMapper.toDto(car);
    }
}