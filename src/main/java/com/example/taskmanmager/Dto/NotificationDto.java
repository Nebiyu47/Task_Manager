package com.example.taskmanmager.Dto;

import com.example.taskmanmager.Entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class NotificationDto {

    private Long notificationId;

    private String content;

    private Long recipientId;
}
