package com.miniproject.rental.controllers;

import com.miniproject.rental.dtos.CarDTO;
import com.miniproject.rental.enums.Segment;
import com.miniproject.rental.mappers.CarMapper;
import com.miniproject.rental.models.Car;
import com.miniproject.rental.services.CarService;

import io.swagger.annotations.ApiOperation;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.miniproject.rental.utilities.Constants.*;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("car/")
public class CarController {
    @Autowired
    private CarService carService;

    private CarMapper carMapper;

    @ApiOperation(value = "return create")
    @PostMapping(value = "create")
    public ResponseEntity<CarDTO> create(@RequestBody @Valid CarDTO body) {
        Car newCar = carMapper.toModel(body);
        Car createdCar = carService.create(newCar);
        CarDTO createdCarDTO = carMapper.toDto(createdCar);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCarDTO);
    }

    @ApiOperation(value = "return all by brand")
    @GetMapping(value = "by-brand")
    public ResponseEntity<List<CarDTO>> getAllByBrand(@RequestParam(value = BRAND) String brand) {
        List<Car> carsFound = carService.getByBrand(brand);
        List<CarDTO> carsDTOFound = carMapper.toDtos(carsFound);

        return carsDTOFound.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(carsDTOFound);
    }

    @ApiOperation(value = "return all by segment")
    @GetMapping(value = "by-segment")
    public ResponseEntity<List<CarDTO>> getAllBySegment(@RequestParam(value = SEGMENT) Segment segment) {
        List<Car> carsFound = carService.getBySegment(segment);
        List<CarDTO> carsDTOFound = carMapper.toDtos(carsFound);

        return carsDTOFound.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(carsDTOFound);
    }

    @ApiOperation(value = "return availables")
    @GetMapping(value = "availables")
    public ResponseEntity<List<CarDTO>> getAvailables() {
        List<Car> carsAvailable = carService.getAvailables();
        List<CarDTO> carsDTOAvailable = carMapper.toDtos(carsAvailable);

        return carsDTOAvailable.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(carsDTOAvailable);
    }

    @ApiOperation(value = "return all by brand asc")
    @GetMapping(value = "by-brand-asc")
    public ResponseEntity<List<CarDTO>> getCarsByBrand() {
        List<Car> carsByBrand = carService.getCarsByBrand();
        List<CarDTO> carsDTOByBrand = carMapper.toDtos(carsByBrand);

        return carsDTOByBrand.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(carsDTOByBrand);
    }
}