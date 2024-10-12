package az.edu.itbrains.blog.services;

import az.edu.itbrains.blog.dtos.category.CategoryDTO;
import az.edu.itbrains.blog.dtos.category.CategoryUpdateDTO;
import az.edu.itbrains.blog.payloads.ApiPayload;
import az.edu.itbrains.blog.payloads.MessageResponse;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.List;

public interface CategoryService {

    ApiPayload<List<CategoryDTO>> getAllCategories();

    MessageResponse createCategory(CategoryDTO dto);

    MessageResponse updateCategory(CategoryDTO categoryDTO);

    MessageResponse removeCategory(Long categoryId);
}
