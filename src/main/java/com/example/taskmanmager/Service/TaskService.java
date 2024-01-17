package com.example.taskmanmager.Service;

import com.example.taskmanmager.Dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTask();
    TaskDto GetByTaskId(Long TaskId);
    void addTask(TaskDto taskDto);
    void  updateTsk(TaskDto taskDto, Long id);
    void deletedTask(Long id);
}
