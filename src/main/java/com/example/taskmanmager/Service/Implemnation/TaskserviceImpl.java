package com.example.taskmanmager.Service.Implemnation;

import com.example.taskmanmager.Dto.TaskDto;
import com.example.taskmanmager.DtoAddpater.TaskAdapter;
import com.example.taskmanmager.Entity.Task;
import com.example.taskmanmager.Service.TaskService;
import com.example.taskmanmager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskserviceImpl  implements TaskService {

   private final TaskRepository taskRepository;
   private final TaskAdapter taskAdapter;

    @Override
    public List<TaskDto> getAllTask() {
        List<Task> tasks=taskRepository.findAll();
        return tasks.stream().map(taskAdapter::taskToTaskDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto GetByTaskId(Long taskId) {
        Task task= taskRepository.findById(taskId).orElse(null);
        if(task!=null){
            return taskAdapter.taskToTaskDto(task);
        }
        return null;
    }

    @Override
    public void addTask(TaskDto taskDto) {
    Task task= taskAdapter.TaskDtoTask(taskDto);
    taskRepository.save(task);
    }

    @Override
    public void updateTsk(TaskDto taskDto) {
        Task exsitingTask = taskRepository.findById(taskDto.getTaskId()).orElse(null);
        if(exsitingTask!=null){
            Task updatedTask= taskAdapter.TaskDtoTask(taskDto);
            taskRepository.save(exsitingTask);
        }
    }


    @Override
    public void deletedTask(Long id) {
         taskRepository.deleteById(id);
    }
}
