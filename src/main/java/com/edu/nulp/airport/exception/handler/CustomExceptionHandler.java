package com.edu.nulp.airport.exception.handler;

import com.edu.nulp.airport.dto.exception.ExceptionResponse;
import com.edu.nulp.airport.exception.NotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NotExistException.class)
    public final ResponseEntity<Object> handleNotExistException(NotExistException exception) {
        return buildExceptionBody(exception, NOT_FOUND);
    }

    private ResponseEntity<Object> buildExceptionBody(Exception exception, HttpStatus httpStatus) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .status(httpStatus.value())
                .message(exception.getMessage())
                .build();
        log.debug(exception.getMessage());
        return ResponseEntity
                .status(httpStatus)
                .body(exceptionResponse);
    }
}
