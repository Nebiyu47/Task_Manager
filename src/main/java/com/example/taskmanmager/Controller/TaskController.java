package com.example.taskmanmager.Controller;

import com.example.taskmanmager.Dto.TaskDto;
import com.example.taskmanmager.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTask(){
        List<TaskDto> taskDtos= taskService.getAllTask();
        return ResponseEntity.ok(taskDtos);
    }
    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto>getTaskbyId(@PathVariable Long taskId ){
        TaskDto taskDto= taskService.GetByTaskId(taskId);
        return ResponseEntity.ok(taskDto);
    }
    @PostMapping
    public ResponseEntity<Void>addTask(@RequestBody TaskDto taskDto){
        taskService.addTask(taskDto);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        try {
            taskService.updateTsk(taskId, taskDto);
            return ResponseEntity.ok("Task Updated Successfully");
        } catch (IllegalArgumentException e) {
            // Handle the case where taskId is null or invalid
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Task ID");
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task");
        }
    }
    @DeleteMapping("/{Taskid}")
    public ResponseEntity<String> deletedTask(@PathVariable Long taskID){
        taskService.deletedTask(taskID);
        return ResponseEntity.ok("Task is been Deleted");
    }

}
