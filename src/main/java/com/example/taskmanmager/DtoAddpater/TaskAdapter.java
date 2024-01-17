package com.example.taskmanmager.DtoAddpater;

import com.example.taskmanmager.Dto.TaskDto;
import com.example.taskmanmager.Entity.Category;
import com.example.taskmanmager.Entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskAdapter {

    public TaskDto taskToTaskDto(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(task.getTaskId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        if(task.getCategory()!=null){
            taskDto.setCategoryId(task.getCategory().getCategoryId());
        }
        return taskDto;
    }
    public Task TaskDtoTask(TaskDto taskDto){
        Task task= new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        Category category = new Category();
        category.setCategoryId(taskDto.getCategoryId());
        task.setCategory(category);
        return  task;
    }
}
