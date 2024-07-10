package com.miniproject.rental.controllers;

import com.miniproject.rental.dtos.RentDTO;
import com.miniproject.rental.mappers.RentMapper;
import com.miniproject.rental.models.Rent;
import com.miniproject.rental.services.RentService;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.miniproject.rental.utilities.Constants.ID;
import static com.miniproject.rental.utilities.Constants.TOKEN;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("rent/")
public class RentController {
    @Autowired
    RentMapper rentMapper;

    @Autowired
    RentService rentService;

    @PostMapping(value = "create/{" + TOKEN + "}")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<RentDTO> create(@PathVariable(value = TOKEN) UUID token, @RequestBody @Valid RentDTO body) {
        Rent newRent = rentMapper.toModel(body);
        Rent createdRent = rentService.create(token, newRent);
        RentDTO createdRentDTO = rentMapper.toDto(createdRent);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdRentDTO);
    }

    @PutMapping(value = "update/{" + TOKEN + "}")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<RentDTO> update(@PathVariable(value = TOKEN) UUID token, @RequestParam(value = ID) Long rentId){
        Rent rentUpdated = rentService.update(token, rentId);
        RentDTO rentDTOUpdated = rentMapper.toDto(rentUpdated);

        return ResponseEntity.ok().body(rentDTOUpdated);
    }

    @GetMapping(value = "by-user/{" + TOKEN + "}")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<List<RentDTO>> getAllCarsRentByClientId(@PathVariable(value = TOKEN) UUID token, @RequestParam(value = ID) Long clientId){
        List<Rent> rents = rentService.getAllCarsRentByClientId(token, clientId);
        List<RentDTO> rentsDTO = rentMapper.toDtos(rents);

        return rentsDTO.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(rentsDTO);
    }
}