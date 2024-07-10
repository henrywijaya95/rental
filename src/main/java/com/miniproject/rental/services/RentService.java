package com.miniproject.rental.services;

import com.miniproject.rental.exceptions.RentalCarException;
import com.miniproject.rental.models.Rent;
import com.miniproject.rental.repositories.RentRepository;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RentService {
    @Autowired
    UserService userService;

    @Autowired
    RentRepository rentRepository;

    public Rent create(UUID token, Rent newRent) {
        userService.getByToken(token);

        return rentRepository.save(newRent);
    }

    public Rent update(UUID token, Long rentId) {
        Rent finalizedRent = getById(token, rentId);
        finalizedRent.setReturnAt(ZonedDateTime.now());

        return rentRepository.save(finalizedRent);
    }

    private Rent getById(UUID token, Long id) {
        if (token != null) {
            userService.getByToken(token);
        }

        Optional<Rent> optionalRent = rentRepository.findById(id);

        if (optionalRent.isEmpty()) {
            throw new RentalCarException(HttpStatus.NOT_FOUND, "Rent not found", "The rent with the provided id: " + id + " was not found in database.");
        }

        return optionalRent.get();
    }

    public List<Rent> getAllCarsRentByClientId(UUID token, Long clientId) {
        userService.getByToken(token);

        return rentRepository.findAllByClientId(clientId);
    }
}