package com.miniproject.rental.dtos;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class RentDTO {
    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private CarDTO carDTO;

    private LocalDateTime rentAt;

    private LocalDateTime returnAt;
}