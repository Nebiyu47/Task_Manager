package com.example.taskmanmager.Controller;

import com.example.taskmanmager.Service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class notificationController {
    private final NotificationService notificationService;

  @PostMapping("/send")
    public ResponseEntity<String>sendNotification(@RequestParam String to, @RequestParam String message){
        notificationService.sendNotification(to,message);
        return ResponseEntity.ok("notification send sucesfully ");
    }
}
