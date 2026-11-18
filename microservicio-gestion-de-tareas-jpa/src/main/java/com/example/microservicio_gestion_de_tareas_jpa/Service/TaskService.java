package com.example.microservicio_gestion_de_tareas_jpa.Service;
import com.example.microservicio_gestion_de_tareas_jpa.DTO.TaskDTO;
import com.example.microservicio_gestion_de_tareas_jpa.TaskStatus.TaskStatus;
import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskDTO createTask(TaskDTO taskDTO);
    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(UUID id);
    TaskDTO updateTask(UUID id, TaskDTO taskDTO);
    TaskDTO updateTaskPartial(UUID id, TaskDTO taskDTO);
    void deleteTask(UUID id);
    List<TaskDTO> getTasksByStatus(TaskStatus status);
}
