package com.example.taskmanmager.Service.Implemnation;

import com.example.taskmanmager.Dto.CategoryDto;
import com.example.taskmanmager.DtoAddpater.CategoryAdapter;
import com.example.taskmanmager.Entity.Category;
import com.example.taskmanmager.Service.CategoryService;
import com.example.taskmanmager.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatagoryServiceIMPL implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryAdapter categoryAdapter;

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categoryDtos= categoryRepository.findAll();
        return categoryDtos.stream().map(category -> categoryAdapter.categoryToCategoryDto(category)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryByDto(Long CategoryId) {
        Category category=categoryRepository.findById(CategoryId).orElse(null);
        return (category!=null)?categoryAdapter.categoryToCategoryDto(category): null;
    }

    @Override
    public void addCategory(CategoryDto categoryDto) {
  Category category= categoryAdapter.categoryDtoToCategory(categoryDto);
  categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryDto categoryDto) {
    Category category=categoryRepository.findById(categoryDto.getCategoryId()).orElse(null);
    if(category!=null){
        Category updatedCategory= categoryAdapter.categoryDtoToCategory(categoryDto);
        categoryRepository.save(updatedCategory);
    }
    }

    @Override
    public void deletedCategory(Long CategoryId) {

   categoryRepository.deleteById(CategoryId);
    }
}
