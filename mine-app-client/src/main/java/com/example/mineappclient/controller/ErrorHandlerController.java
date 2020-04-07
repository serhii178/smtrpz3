package com.example.mineappclient.controller;

import com.example.mineappclient.dto.ApiResponse;
import com.example.mineappclient.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.hibernate.TypeMismatchException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ApiResponse> handleConstraintViolationException() {
        return new ResponseEntity<>(
                new ApiResponse(
                        false,
                        "Cannot save Car"
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    protected ResponseEntity<ApiResponse> handleResourceNotFoundException() {
        return new ResponseEntity<>(
                new ApiResponse(
                        false,
                        "No such car"
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<>(
                new ApiResponse(
                        false,
                        "Not valid field"
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidFormatException.class)
    protected ResponseEntity<ApiResponse> handleHttpMessageNotReadableException() {
        return new ResponseEntity<>(
                new ApiResponse(
                        false,
                        "Bad Year"
                ),
                HttpStatus.NOT_FOUND
        );
    }

}
