package com.miniproject.rental.services;

import com.miniproject.rental.enums.Role;
import com.miniproject.rental.enums.Segment;
import com.miniproject.rental.exceptions.RentalCarException;
import com.miniproject.rental.models.Car;
import com.miniproject.rental.models.User;
import com.miniproject.rental.repositories.CarRepository;
import com.miniproject.rental.utilities.Constants;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarService {
    @Autowired
    private UserService userService;

    @Autowired
    private CarRepository carRepository;

    public Car create(UUID token, Car newCar) {
        User creator = userService.getByToken(token);

        if (!creator.getRole().equals(Role.MANAGER)) {
            throw new RentalCarException(HttpStatus.FORBIDDEN, Constants.HEADER_FORBIDDEN, Constants.BODY_LACK_PERMITIONS);
        }

        return carRepository.save(newCar);
    }

    public List<Car> getByBrand(UUID token, String brand) {
        if (token != null) {
            userService.getByToken(token);
        }

        return carRepository.findByBrand(brand);
    }

    public List<Car> getBySegment(UUID token, Segment segment) {
        if (token != null) {
            userService.getByToken(token);
        }

        return carRepository.findBySegment(segment);
    }

    public List<Car> getAvailables(UUID token) {
        userService.getByToken(token);

        return carRepository.findAvailables();
    }

    public List<Car> getCarsByBrand(UUID token) {
        userService.getByToken(token);

        return carRepository.findAllByOrderByBrandAsc();
    }
}