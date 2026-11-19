package com.example.microservicio_gestion_de_tareas_jpa.Converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.microservicio_gestion_de_tareas_jpa.TaskStatus.TaskStatus;

@Component
public class StringToTaskStatusConverter implements Converter<String, TaskStatus> {

    @Override
    public TaskStatus convert(String source) {
        return TaskStatus.fromValue(source);
    }
    
}
