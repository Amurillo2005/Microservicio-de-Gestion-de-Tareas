package com.example.microservicio_gestion_de_tareas_jpa.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private int status;
    private String error;
    private String message;
}
