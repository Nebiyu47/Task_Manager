package com.example.taskmanmager.DtoAddpater;

import com.example.taskmanmager.Dto.NotificationDto;
import com.example.taskmanmager.Entity.Notification;
import com.example.taskmanmager.Entity.User;
import com.example.taskmanmager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationAdapter {
    private final UserRepository userRepository;
    public NotificationDto notificationtoDto(Notification notification){
        NotificationDto notificationDto= new NotificationDto();
        notificationDto.setNotificationId(notification.getNotificationId());
        notificationDto.setMessage(notification.getMessage());
        notificationDto.setUserId(notification.getUser().getUserId());
       return notificationDto;
    }

    public Notification notificationTODto(NotificationDto notificationDto){
        Notification notification= new Notification();
        notification.setNotificationId(notificationDto.getNotificationId());
        notification.setMessage(notificationDto.getMessage());
        notification.setUser(userRepository.findById(notificationDto.getUserId()).orElse(null));
        return notification;
    }
}
