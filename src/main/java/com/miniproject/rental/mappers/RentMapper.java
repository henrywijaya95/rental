package com.miniproject.rental.mappers;

import com.miniproject.rental.dtos.RentDTO;
import com.miniproject.rental.mappers.utils.RentMapperUtil;
import com.miniproject.rental.models.Rent;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = {RentMapperUtil.class})
public interface RentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "returnAt", ignore = true)
    @Mapping(target = "client", source = "userId", qualifiedByName = "findUser")
    @Mapping(target = "car", source = "carDTO.id", qualifiedByName = "findCar")
    Rent toModel(RentDTO rentDTO);

    @Mapping(target = "userId", expression = "java((rent.getClient().getId()))")
    @Mapping(target = "carDTO", source = "car", qualifiedByName = "fromCartoCarDTO")
    RentDTO toDto(Rent rent);

    List<RentDTO> toDtos(List<Rent> rents);
}