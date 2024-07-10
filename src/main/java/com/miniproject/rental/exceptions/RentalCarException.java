package com.miniproject.rental.exceptions;

import lombok.Getter;

import org.springframework.http.HttpStatus;

public class RentalCarException extends RuntimeException {
    @Getter
    private HttpStatus httpStatus;

    @Getter
    private String header;

    public RentalCarException(String body) {
        super(body);
    }

    public RentalCarException(HttpStatus httpStatus, String body) {
        this(body);
        this.httpStatus = httpStatus;
    }

    public RentalCarException(HttpStatus httpStatus, String header, String body) {
        this(httpStatus, body);
        this.header = header;
    }
}