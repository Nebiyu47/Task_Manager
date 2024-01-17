package com.example.taskmanmager.DtoAddpater;

import com.example.taskmanmager.Dto.NotificationDto;
import com.example.taskmanmager.Entity.Notification;
import com.example.taskmanmager.Entity.User;

public class NotificationAdapter {
    public NotificationDto notificationToDto(Notification notification){
        NotificationDto notificationDto= new NotificationDto();
        notificationDto.setNotificationId(notification.getNotificationId());
        notificationDto.setContent(notification.getContent());
       if(notification.getRecipient()!=null){
           notificationDto.setRecipientId(notification.getRecipient().getUserId());
       }
       return notificationDto;
    }

    public Notification notificationTODto(NotificationDto notificationDto){
        Notification notification= new Notification();
        notification.setNotificationId(notificationDto.getNotificationId());
        notification.setContent(notificationDto.getContent());
        User recipient= new User();
        recipient.setUserId(notificationDto.getRecipientId());
        return notification;
    }
}
