package com.example.taskmanmager.repository;

import com.example.taskmanmager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
