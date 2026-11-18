package com.example.microservicio_gestion_de_tareas_jpa.DTO;

import java.time.LocalDate;
import java.util.UUID;

import com.example.microservicio_gestion_de_tareas_jpa.TaskStatus.TaskStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO {
    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private String assignedTo;
    private LocalDate dueDate;
}
