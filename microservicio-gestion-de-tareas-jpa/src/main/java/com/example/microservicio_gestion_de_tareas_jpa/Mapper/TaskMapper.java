package com.example.microservicio_gestion_de_tareas_jpa.Mapper;

import com.example.microservicio_gestion_de_tareas_jpa.Model.Task;
import org.springframework.stereotype.Component;
import com.example.microservicio_gestion_de_tareas_jpa.DTO.TaskDTO;

@Component 
public class TaskMapper {

    //Conversión de DTO a Entidad
    public Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setAssignedTo(taskDTO.getAssignedTo());
        task.setDueDate(taskDTO.getDueDate());

        return task;
    }

    //Conversión de Entidad a DTO
    public TaskDTO toDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setAssignedTo(task.getAssignedTo());
        taskDTO.setDueDate(task.getDueDate());

        return taskDTO;
    }
}
