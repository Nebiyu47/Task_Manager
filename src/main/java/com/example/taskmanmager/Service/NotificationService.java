package com.example.taskmanmager.Service;

import com.example.taskmanmager.Dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    void sendNotification(String to,String message);

}
