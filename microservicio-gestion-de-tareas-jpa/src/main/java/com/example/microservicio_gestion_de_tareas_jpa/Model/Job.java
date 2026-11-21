package com.example.microservicio_gestion_de_tareas_jpa.Model;

import java.time.LocalDateTime;
import java.util.UUID;
import com.example.microservicio_gestion_de_tareas_jpa.JobStatus.JobStatus;
import com.example.microservicio_gestion_de_tareas_jpa.JobType.JobType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
@Entity 
@Table(name = "jobs")
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column (name = "id", nullable = false)
    private UUID id;

    @Column(name = "task_id", nullable = false)
    private UUID taskId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private JobType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_status", nullable = false)
    private JobStatus jobStatus = JobStatus.SCHEDULED;

    @Column(name = "scheduled_at", nullable = false)
    private LocalDateTime scheduledAt;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; 

    @PrePersist
    public void prePersist(){
        if (this.createdAt == null) {
           this.createdAt = LocalDateTime.now();
        }
    }
}
