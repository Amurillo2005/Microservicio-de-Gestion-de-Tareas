package com.example.microservicio_gestion_de_tareas_jpa.Repository;

import com.example.microservicio_gestion_de_tareas_jpa.Model.Job;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job, UUID> {
}