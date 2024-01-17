package com.example.taskmanmager.repository;

import com.example.taskmanmager.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
