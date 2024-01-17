package com.example.taskmanmager.Controller;

import com.example.taskmanmager.Dto.TaskDto;
import com.example.taskmanmager.Service.TaskService;
import lombok.RequiredArgsConstructor;
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
    @PostMapping
    public ResponseEntity<Void>addTask(@RequestBody TaskDto taskDto){
        taskService.addTask(taskDto);
        return ResponseEntity.ok().build();
    }
}
