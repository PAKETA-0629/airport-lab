package com.edu.nulp.airport.dto.exception;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionResponse {
    private int status;
    private String message;
}
