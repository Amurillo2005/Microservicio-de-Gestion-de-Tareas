package com.example.microservicio_gestion_de_tareas_jpa.Mapper;

import org.springframework.stereotype.Component;
import com.example.microservicio_gestion_de_tareas_jpa.Model.Job;
import com.example.microservicio_gestion_de_tareas_jpa.DTO.JobDTO;

@Component
public class JobMapper {
    
    //Conversión de DTO a Entidad
    public Job toEntity(JobDTO jobDTO){
        Job job = new Job();

        job.setType(jobDTO.getType());
        job.setScheduledAt(jobDTO.getScheduledAt());

        return job;
    }

    //Conversión de Entidad a DTO
    public JobDTO toDTO(Job job){
        JobDTO jobDTO = new JobDTO();

        jobDTO.setScheduledAt(job.getScheduledAt());
        jobDTO.setType(job.getType());

        return jobDTO;
    }
}
