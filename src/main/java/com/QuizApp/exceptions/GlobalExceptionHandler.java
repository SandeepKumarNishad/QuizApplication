package com.QuizApp.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResouceNotFoundException.class)
    String ResourceNotFound(ResouceNotFoundException ex){
        return ex.getMessage();
    }
}
