package com.example.taskmanmager.repository;

import com.example.taskmanmager.Entity.Notification;
import com.example.taskmanmager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findByUser(User user);
}
