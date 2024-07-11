package com.miniproject.rental.services;

import com.miniproject.rental.enums.Segment;
import com.miniproject.rental.models.Car;
import com.miniproject.rental.repositories.CarRepository;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    @Autowired
    private UserService userService;

    @Autowired
    private CarRepository carRepository;

    @Transactional(rollbackFor = Throwable.class)
    public Car create(Car newCar) {
        return carRepository.save(newCar);
    }

    @Transactional(readOnly = true)
    public List<Car> getByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    @Transactional(readOnly = true)
    public List<Car> getBySegment(Segment segment) {
        return carRepository.findBySegment(segment);
    }

    @Transactional(readOnly = true)
    public List<Car> getAvailables() {
        return carRepository.findAvailables();
    }

    @Transactional(readOnly = true)
    public List<Car> getCarsByBrand() {
        return carRepository.findAllByOrderByBrandAsc();
    }
}