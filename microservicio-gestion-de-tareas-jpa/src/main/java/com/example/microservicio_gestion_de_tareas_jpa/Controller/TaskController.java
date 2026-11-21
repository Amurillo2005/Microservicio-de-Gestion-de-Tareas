package com.example.microservicio_gestion_de_tareas_jpa.Controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio_gestion_de_tareas_jpa.DTO.TaskDTO;
import com.example.microservicio_gestion_de_tareas_jpa.Service.Task.TaskService;
import com.example.microservicio_gestion_de_tareas_jpa.TaskStatus.TaskStatus;
import com.example.microservicio_gestion_de_tareas_jpa.Validation.OnCreate;
import com.example.microservicio_gestion_de_tareas_jpa.Validation.OnUpdate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@Validated(OnCreate.class) @RequestBody TaskDTO taskDTO){
        TaskDTO createdTask = taskService.createTask(taskDTO);
        return ResponseEntity.created(URI.create("/tasks/" + createdTask.getId())).body(createdTask);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        List<TaskDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable UUID id){
        TaskDTO task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable UUID id, @Validated(OnUpdate.class) @RequestBody TaskDTO taskDTO){
        TaskDTO updatedTask = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTaskPartial(@PathVariable UUID id, @Validated @RequestBody TaskDTO taskDTO){
        TaskDTO updatedTaskPartial = taskService.updateTaskPartial(id, taskDTO);
        return ResponseEntity.ok(updatedTaskPartial);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskDTO>> getTasksByStatus(@PathVariable TaskStatus status){
        List<TaskDTO> tasks = taskService.getTasksByStatus(status);
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
