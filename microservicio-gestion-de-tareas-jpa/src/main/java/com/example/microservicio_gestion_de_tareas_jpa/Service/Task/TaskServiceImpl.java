package com.example.microservicio_gestion_de_tareas_jpa.Service.Task;

import org.springframework.stereotype.Service;
import com.example.microservicio_gestion_de_tareas_jpa.DTO.TaskDTO;
import com.example.microservicio_gestion_de_tareas_jpa.Repository.TaskRepository;
import com.example.microservicio_gestion_de_tareas_jpa.TaskStatus.TaskStatus;
import com.example.microservicio_gestion_de_tareas_jpa.Model.Task;
import com.example.microservicio_gestion_de_tareas_jpa.Mapper.TaskMapper;
import com.example.microservicio_gestion_de_tareas_jpa.Exception.TaskNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;
    private final TaskMapper mapper;

    public TaskServiceImpl(TaskRepository repo, TaskMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO){
        Task task = mapper.toEntity(taskDTO);

        return mapper.toDTO(repo.save(task));
    }

    @Override
    public List<TaskDTO> getAllTasks(){
        List<Task> tasks = repo.findAll();
        return tasks.stream().map(mapper::toDTO).toList();
    }

    @Override
    public TaskDTO getTaskById(UUID id){
        Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException("No se encontró la tarea con el id: " + id));
        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO updateTask(UUID id, TaskDTO taskDTO){

        Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException("No se encontró la tarea con el id: " + id));
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setAssignedTo(taskDTO.getAssignedTo());
        task.setDueDate(taskDTO.getDueDate());

        return mapper.toDTO(repo.save(task));
    }

    @Override
    public TaskDTO updateTaskPartial(UUID id, TaskDTO taskDTO){

        Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException("No se encontró la tarea con el id: " + id));
        if (taskDTO.getTitle() != null) task.setTitle(taskDTO.getTitle());
        if (taskDTO.getDescription() != null) task.setDescription(taskDTO.getDescription());
        if (taskDTO.getStatus() != null) task.setStatus(taskDTO.getStatus());
        if (taskDTO.getAssignedTo() != null) task.setAssignedTo(taskDTO.getAssignedTo());
        if (taskDTO.getDueDate() != null) task.setDueDate(taskDTO.getDueDate());

        return mapper.toDTO(repo.save(task));
    }

    @Override
    public List<TaskDTO> getTasksByStatus(TaskStatus status){
        List<Task> tasks = repo.findByStatus(status);
        return tasks.stream().map(mapper::toDTO).toList();
    }

    @Override
    public void deleteTask(UUID id){
        Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException("No se encontró la tarea con el id: " + id));
        repo.delete(task);
    }

}
