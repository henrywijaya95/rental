package com.miniproject.rental.controllers;

import com.miniproject.rental.dtos.RentDTO;
import com.miniproject.rental.mappers.RentMapper;
import com.miniproject.rental.models.Rent;
import com.miniproject.rental.services.RentService;

import io.swagger.annotations.ApiOperation;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.miniproject.rental.utilities.Constants.ID;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("rent/")
public class RentController {
    @Autowired
    private RentService rentService;

    private RentMapper rentMapper;

    @ApiOperation(value = "return create")
    @PostMapping(value = "create")
    public ResponseEntity<RentDTO> create(@RequestBody @Valid RentDTO body) {
        Rent newRent = rentMapper.toModel(body);
        Rent createdRent = rentService.create(newRent);
        RentDTO createdRentDTO = rentMapper.toDto(createdRent);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdRentDTO);
    }

    @ApiOperation(value = "return update")
    @PutMapping(value = "update")
    public ResponseEntity<RentDTO> update(@RequestParam(value = ID) Long rentId){
        Rent rentUpdated = rentService.update(rentId);
        RentDTO rentDTOUpdated = rentMapper.toDto(rentUpdated);

        return ResponseEntity.ok().body(rentDTOUpdated);
    }

    @ApiOperation(value = "return all by client id")
    @GetMapping(value = "by-user")
    public ResponseEntity<List<RentDTO>> getAllCarsRentByClientId(@RequestParam(value = ID) Long clientId){
        List<Rent> rents = rentService.getAllCarsRentByClientId(clientId);
        List<RentDTO> rentsDTO = rentMapper.toDtos(rents);

        return rentsDTO.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(rentsDTO);
    }
}