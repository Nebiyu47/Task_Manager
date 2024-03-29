package com.example.taskmanmager.DtoAddpater;

import com.example.taskmanmager.Dto.CategoryDto;
import com.example.taskmanmager.Entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryAdapter {

    public CategoryDto categoryToCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setName(category.getName());
        return categoryDto;

    }
    public Category categoryDtoToCategory(CategoryDto categoryDto){
        Category category= new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setName(categoryDto.getName());
        return category;
    }
}
