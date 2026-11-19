package com.example.microservicio_gestion_de_tareas_jpa.Exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message){
        super(message);
    }
}
