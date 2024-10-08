package az.edu.itbrains.blog.services.impl;

import az.edu.itbrains.blog.dtos.category.CategoryDTO;
import az.edu.itbrains.blog.mapper.CategoryMapper;
import az.edu.itbrains.blog.models.Category;
import az.edu.itbrains.blog.payloads.ApiPayload;
import az.edu.itbrains.blog.payloads.ApiResponse;
import az.edu.itbrains.blog.repositories.CategoryRepository;
import az.edu.itbrains.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    private final CategoryMapper mapper;

    @Override
    public ApiPayload<List<CategoryDTO>> getAllCategories() {
        List<Category> categories = repository.findAll();
        return new ApiPayload<>(true, mapper.toDto(categories));
    }

    @Override
    public ApiResponse createCategory(CategoryDTO dto) {
        try {
            Category category = mapper.toEntity(dto);
            Category name = repository.findByName(category.getName());
            if (name != null) {
                return new ApiResponse("Category already exists", false);
            }
            category.setId(null);
            repository.save(category);
            return new ApiResponse("Category created successfully", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }


}
