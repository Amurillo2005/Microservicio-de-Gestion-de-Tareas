package com.example.microservicio_gestion_de_tareas_jpa.Service.Job;

import com.example.microservicio_gestion_de_tareas_jpa.DTO.JobDTO;
import java.util.UUID;

public interface JobService {
    JobDTO scheduleJob(UUID taskId, JobDTO jobDTO);
}
