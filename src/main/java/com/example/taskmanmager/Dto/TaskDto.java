package com.example.taskmanmager.Dto;

import com.example.taskmanmager.Entity.Category;
import com.example.taskmanmager.Enum.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class TaskDto {
    private Long taskId;

    private String title;

    private String description;

    private TaskStatus status;


    private Long categoryId;

}
