package com.example.microservicio_gestion_de_tareas_jpa.Repository;
import com.example.microservicio_gestion_de_tareas_jpa.Model.Task;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.microservicio_gestion_de_tareas_jpa.TaskStatus.TaskStatus;


public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByStatus(TaskStatus status);
}
