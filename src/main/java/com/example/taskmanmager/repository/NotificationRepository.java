package com.example.taskmanmager.repository;

import com.example.taskmanmager.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
