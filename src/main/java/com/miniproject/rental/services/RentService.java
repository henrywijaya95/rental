package com.miniproject.rental.services;

import com.miniproject.rental.exceptions.RentalCarException;
import com.miniproject.rental.models.Rent;
import com.miniproject.rental.repositories.RentRepository;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentService {
    @Autowired
    private UserService userService;

    @Autowired
    private RentRepository rentRepository;

    @Transactional(rollbackFor = Throwable.class)
    public Rent create(Rent newRent) {
        return rentRepository.save(newRent);
    }

    @Transactional(rollbackFor = Throwable.class)
    public Rent update( Long rentId) {
        Rent finalizedRent = getById(rentId);
        finalizedRent.setReturnAt(LocalDateTime.now());

        return rentRepository.save(finalizedRent);
    }

    @Transactional(rollbackFor = Throwable.class)
    private Rent getById(Long id) {
        Optional<Rent> optionalRent = rentRepository.findById(id);

        if (optionalRent.isPresent()) {
            throw new RentalCarException(HttpStatus.NOT_FOUND, "Rent not found", "The rent with the provided id: " + id + " was not found in database.");
        }

        return optionalRent.get();
    }

    @Transactional(rollbackFor = Throwable.class)
    public List<Rent> getAllCarsRentByClientId(Long clientId) {
        return rentRepository.findAllByClientId(clientId);
    }
}