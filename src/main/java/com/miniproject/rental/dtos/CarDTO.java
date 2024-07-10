package com.miniproject.rental.dtos;

import com.miniproject.rental.enums.Segment;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class CarDTO {
    private Long id;

    private Segment segment;

    private BigDecimal dailyPrice;

    @NotBlank(message = "Brand is mandatory")
    private String brand;
}