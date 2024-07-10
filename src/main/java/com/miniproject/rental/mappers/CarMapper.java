package com.miniproject.rental.mappers;

import com.miniproject.rental.dtos.CarDTO;
import com.miniproject.rental.models.Car;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CarMapper {
    @Mapping(target = "id", ignore = true)
    Car toModel(CarDTO carDTO);

    CarDTO toDto(Car car);

    List<CarDTO> toDtos(List<Car> carsFound);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Car partialUpdate(CarDTO carDTO, @MappingTarget Car car);
}