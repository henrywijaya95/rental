package com.miniproject.rental.mappers;

import com.miniproject.rental.dtos.CarDTO;
import com.miniproject.rental.models.Car;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CarMapper {
    @Mapping(target = "id", ignore = true)
    Car toModel(CarDTO carDTO);

    CarDTO toDto(Car car);

    List<CarDTO> toDtos(List<Car> carsFound);
}