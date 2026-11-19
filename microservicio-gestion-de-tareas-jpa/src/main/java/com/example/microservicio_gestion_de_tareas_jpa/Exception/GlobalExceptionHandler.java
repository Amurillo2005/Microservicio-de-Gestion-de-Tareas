package com.example.microservicio_gestion_de_tareas_jpa.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.microservicio_gestion_de_tareas_jpa.DTO.ErrorDTO;

@RestControllerAdvice 
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleTaskNotFoundException(TaskNotFoundException ex){
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
