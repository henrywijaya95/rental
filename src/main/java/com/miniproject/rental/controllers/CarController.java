package com.miniproject.rental.controllers;

import com.miniproject.rental.dtos.CarDTO;
import com.miniproject.rental.enums.Segment;
import com.miniproject.rental.mappers.CarMapper;
import com.miniproject.rental.models.Car;
import com.miniproject.rental.services.CarService;

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
@RequestMapping("car/")
public class CarController {
    @Autowired
    CarMapper carMapper;

    @Autowired
    CarService carService;

    @PostMapping(value = "create/{" + TOKEN + "}")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<CarDTO> create(@PathVariable(value = TOKEN) UUID token, @RequestBody @Valid CarDTO body) {
        Car newCar = carMapper.toModel(body);
        Car createdCar = carService.create(token, newCar);
        CarDTO createdCarDTO = carMapper.toDto(createdCar);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCarDTO);
    }

    @GetMapping(value = "by-brand/{" + TOKEN + "}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CarDTO>> getAllByBrand(@PathVariable(value = TOKEN) UUID token, @RequestParam(value = BRAND) String brand) {
        List<Car> carsFound = carService.getByBrand(token, brand);
        List<CarDTO> carsDTOFound = carMapper.toDtos(carsFound);

        return carsDTOFound.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(carsDTOFound);
    }

    @GetMapping(value = "by-segment/{" + TOKEN + "}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CarDTO>> getAllBySegment(@PathVariable(value = TOKEN) UUID token, @RequestParam(value = SEGMENT) Segment segment) {
        List<Car> carsFound = carService.getBySegment(token, segment);
        List<CarDTO> carsDTOFound = carMapper.toDtos(carsFound);

        return carsDTOFound.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(carsDTOFound);
    }

    @GetMapping(value = "availables/{" + TOKEN + "}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CarDTO>> getAvailables(@PathVariable(value = TOKEN) UUID token) {
        List<Car> carsAvailable = carService.getAvailables(token);
        List<CarDTO> carsDTOAvailable = carMapper.toDtos(carsAvailable);

        return carsDTOAvailable.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(carsDTOAvailable);
    }

    @GetMapping(value = "by-brand-asc/{" + TOKEN + "}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CarDTO>> getCarsByBrand(@PathVariable(value = TOKEN) UUID token) {
        List<Car> carsByBrand = carService.getCarsByBrand(token);
        List<CarDTO> carsDTOByBrand = carMapper.toDtos(carsByBrand);

        return carsDTOByBrand.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(carsDTOByBrand);
    }
}