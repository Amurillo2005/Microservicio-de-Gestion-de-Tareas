package com.example.microservicio_gestion_de_tareas_jpa.Service.Job;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.microservicio_gestion_de_tareas_jpa.DTO.JobDTO;
import com.example.microservicio_gestion_de_tareas_jpa.Exception.TaskNotFoundException;
import com.example.microservicio_gestion_de_tareas_jpa.Mapper.JobMapper;
import com.example.microservicio_gestion_de_tareas_jpa.Model.Job;
import com.example.microservicio_gestion_de_tareas_jpa.Model.Task;
import com.example.microservicio_gestion_de_tareas_jpa.Repository.JobRepository;
import com.example.microservicio_gestion_de_tareas_jpa.Repository.TaskRepository;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository repo;
    private final JobMapper mapper;
    private final TaskRepository repoTask;

    public JobServiceImpl(JobRepository repo, JobMapper mapper, TaskRepository repoTask){
        this.mapper = mapper;
        this.repo = repo;
        this.repoTask = repoTask;
    }

    @Override
    public JobDTO scheduleJob(UUID taskId, JobDTO jobDTO) {
        Task task = repoTask.findById(taskId).orElseThrow(() -> new TaskNotFoundException("No se encontró la tarea con el id: " + taskId));
        Job job = mapper.toEntity(jobDTO);
        job.setTaskId(task.getId());
        return mapper.toDTO(repo.save(job));
    }
}
