package com.miniproject.rental.models;

import com.miniproject.rental.enums.Segment;
import com.miniproject.rental.enums.converters.SegmentConverter;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = SegmentConverter.class)
    private Segment segment;

    @Column(name = "daily_price")
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "200.0")
    @Digits(integer = 3, fraction = 2)
    private BigDecimal dailyPrice;

    @NotBlank(message = "Brand is mandatory")
    private String brand;
}