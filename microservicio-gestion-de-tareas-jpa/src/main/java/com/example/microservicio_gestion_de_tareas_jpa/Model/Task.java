package com.example.microservicio_gestion_de_tareas_jpa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import com.example.microservicio_gestion_de_tareas_jpa.TaskStatus.TaskStatus;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column (name = "id", nullable = false)
    private UUID id;

    @NotBlank
    @Size (max = 100)
    @Column (name = "title", nullable = false, length = 100)
    private String title;

    @Size (max = 255)
    @Column (name = "description", length = 255)
    private String description;

    @NotNull 
    @Enumerated(EnumType.STRING)
    @Column (name = "status", nullable = false)
    private TaskStatus status = TaskStatus.PENDING;

    @Size(max = 100)
    @Column (name = "assigned_to", length = 100)
    private String assignedTo;

    @Column (name = "due_date")
    private LocalDate dueDate;
}
