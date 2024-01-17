package com.example.taskmanmager.repository;

import com.example.taskmanmager.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category ,Long> {
}
