package com.example.taskmanmager.Service.Implemnation;

import com.example.taskmanmager.Dto.TaskDto;
import com.example.taskmanmager.Dto.UserDto;
import com.example.taskmanmager.DtoAddpater.TaskAdapter;
import com.example.taskmanmager.DtoAddpater.UserAdapter;
import com.example.taskmanmager.Entity.Task;
import com.example.taskmanmager.Entity.User;
import com.example.taskmanmager.Enum.TaskStatus;
import com.example.taskmanmager.Service.NotificationService;
import com.example.taskmanmager.Service.TaskService;
import com.example.taskmanmager.repository.TaskRepository;
import com.example.taskmanmager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskserviceImpl  implements TaskService {

   private final TaskRepository taskRepository;
   private final TaskAdapter taskAdapter;
   private final ApplicationEventPublisher applicationEventPublisher;
   private final NotificationService notificationService;
   private final UserAdapter userAdapter;
    private final UserRepository userRepository;


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
        // Convert TaskDto to Task entity
        Task task = taskAdapter.TaskDtoTask(taskDto);

        // Extract the UserDto from the TaskDto
        UserDto userDto = taskDto.getAssigned();

        // Convert UserDto to User entity
        User user = userAdapter.UserDtoToUser(userDto);

        // Save the User entity first
        userRepository.save(user);

        // Set the User entity as assignee in the Task entity
        task.setAssignee(user);

        // Save the Task entity
        taskRepository.save(task);
    }

    @Override
    public void updateTsk(Long taskId, TaskDto taskDto) {
        try {
            if (taskId == null || taskId <= 0) {
                throw new IllegalArgumentException("Invalid Task ID");
            }

            Optional<Task> task = taskRepository.findById(taskId);
            if (task.isPresent()) {
                Task existingTask = task.get();

                // Your existing update logic
                existingTask.setStatus(taskDto.getStatus());
                existingTask.setTitle(taskDto.getTitle());
                existingTask.setDescription(taskDto.getDescription());

                taskRepository.save(existingTask);
                handleChangeANDnOTIFY(taskDto, taskDto.getStatus());
            } else {
                throw new IllegalArgumentException("Task not found with ID: " + taskId);
            }
        } catch (Exception e) {
            // Log or print the exception details
            e.printStackTrace(); // Add appropriate logging based on your application's logging framework
            throw new RuntimeException("Error updating task", e);

            }
    }




    @Override
    public void deletedTask(Long id) {
         taskRepository.deleteById(id);
    }
    private void handleChangeANDnOTIFY(TaskDto taskDto, TaskStatus taskStatus){
        if(taskDto.getStatus()!=null){
            String recipentEmail=taskDto.getAssigned().getEmail();
            String notificationContent=" Task Status has been chanded to" + taskStatus;
            notificationService.sendNotification(recipentEmail,notificationContent);
        }

    }
}
