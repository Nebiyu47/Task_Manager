package com.example.taskmanmager.Controller;

import com.example.taskmanmager.Dto.CategoryDto;
import com.example.taskmanmager.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCATEGORY(){
        List<CategoryDto> categoryDtos= categoryService.getAllCategory();
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCATEGORIESById(@PathVariable Long categoryId){
        CategoryDto categoryDto=categoryService.getCategoryByDto(categoryId);
        return new  ResponseEntity<>(categoryDto,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void>addCategories(@RequestBody CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<Void>categoriesUpdated(@PathVariable Long categoryId ,@RequestBody CategoryDto categoryDto){
        categoryDto.setCategoryId(categoryId);
        categoryService.updateCategory(categoryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void>deletedcategory(@PathVariable Long categoryId){
        categoryService.deletedCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
