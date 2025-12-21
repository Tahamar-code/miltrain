package com.miltrainApp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFound(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }


    @ExceptionHandler(TrainingNotFoundException.class)
    public ResponseEntity <Map<String, String>> handleTrainingNotFound(TrainingNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(Map.of("error",exception.getMessage()));
    }


    @ExceptionHandler(TrainingMaxSetLimitException.class)
    public ResponseEntity<Map<String, String>> handleErrorLimit(TrainingMaxSetLimitException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(Map.of("error", exception.getMessage()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity <Map<String, String>> handleOther(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(Map.of("error", "Something went wrong!\n" + exception.getMessage()));
    }
}
