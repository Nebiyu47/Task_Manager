package com.example.taskmanmager.Service;

import com.example.taskmanmager.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategory();
    CategoryDto getCategoryByDto(Long CategoryId);
    void addCategory(CategoryDto categoryDto);
    void updateCategory(CategoryDto categoryDto);
    void deletedCategory(Long CategoryId);

}
