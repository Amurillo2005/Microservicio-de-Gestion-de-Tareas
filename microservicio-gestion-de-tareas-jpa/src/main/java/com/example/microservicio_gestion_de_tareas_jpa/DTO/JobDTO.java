package com.example.microservicio_gestion_de_tareas_jpa.DTO;

import java.time.LocalDateTime;
import com.example.microservicio_gestion_de_tareas_jpa.JobType.JobType;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
public class JobDTO {

    @NotNull
    private JobType type;

    @NotNull
    @Future 
    private LocalDateTime scheduledAt;
}
