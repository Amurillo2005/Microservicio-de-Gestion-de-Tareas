package com.example.microservicio_gestion_de_tareas_jpa.DTO;

import java.time.LocalDate;
import java.util.UUID;

import com.example.microservicio_gestion_de_tareas_jpa.TaskStatus.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO {
    private UUID id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 255)
    private String description;

    private TaskStatus status;

    @Size(max = 100)
    private String assignedTo;
    
    private LocalDate dueDate;
}
