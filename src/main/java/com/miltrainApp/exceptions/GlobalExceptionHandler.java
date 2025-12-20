package com.miltrainApp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(TrainingNotFoundException.class)
    public ResponseEntity<String> handleNotFound(TrainingNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(exception.getMessage());
    }


    @ExceptionHandler(TrainingMaxSetLimitException.class)
    public ResponseEntity<String> handleErrorLimit(TrainingMaxSetLimitException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(exception.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOther(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Something went wrong!" + exception.getMessage());
    }
}
