package az.edu.itbrains.blog.services;

import az.edu.itbrains.blog.dtos.category.CategoryCreateDTO;
import az.edu.itbrains.blog.dtos.category.CategoryDTO;
import az.edu.itbrains.blog.payloads.ApiPayload;
import az.edu.itbrains.blog.payloads.ApiResponse;

import java.util.List;

public interface CategoryService {

    ApiPayload<List<CategoryDTO>> getAllCategories();

    ApiResponse createCategory(CategoryDTO dto);
}
