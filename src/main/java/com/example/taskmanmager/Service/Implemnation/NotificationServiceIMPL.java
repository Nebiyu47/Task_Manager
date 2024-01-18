package com.example.taskmanmager.Service.Implemnation;

import com.example.taskmanmager.Dto.NotificationDto;
import com.example.taskmanmager.DtoAddpater.NotificationAdapter;
import com.example.taskmanmager.Entity.Notification;
import com.example.taskmanmager.Entity.User;
import com.example.taskmanmager.Service.NotificationService;
import com.example.taskmanmager.repository.NotificationRepository;
import com.example.taskmanmager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceIMPL implements NotificationService {


    private final JavaMailSender javaMailSender;

    @Override
    public void sendNotification(String to, String message) {

    SimpleMailMessage message1= new SimpleMailMessage();
    message1.setTo(to);
    message1.setSubject("Task status has been changed");
    message1.setText(message);
    javaMailSender.send(message1);



    }



}
