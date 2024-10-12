package az.edu.itbrains.blog.services.impl;

import az.edu.itbrains.blog.dtos.category.CategoryDTO;
import az.edu.itbrains.blog.exception.CategoryOperationNotSupportedException;
import az.edu.itbrains.blog.exception.ResourceNotFoundException;
import az.edu.itbrains.blog.mapper.CategoryMapper;
import az.edu.itbrains.blog.models.Category;
import az.edu.itbrains.blog.payloads.ApiPayload;
import az.edu.itbrains.blog.payloads.MessageResponse;
import az.edu.itbrains.blog.repositories.CategoryRepository;
import az.edu.itbrains.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper mapper;

    @Override
    public ApiPayload<List<CategoryDTO>> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return new ApiPayload<>(true, mapper.toDto(categories));
    }

    @Override
    public MessageResponse createCategory(CategoryDTO dto) {
        try {
            Category category = mapper.toEntity(dto);
            Category name = categoryRepository.findByName(category.getName());
            if (name != null) {
                return new MessageResponse("Category already exists");
            }
            category.setId(null);
            categoryRepository.save(category);
            return new MessageResponse("Category created successfully");
        } catch (Exception e) {
            return new MessageResponse(e.getMessage());
        }
    }


    @Override
    public MessageResponse updateCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.getId() == null || categoryDTO.getId() == 0) {
            throw new CategoryOperationNotSupportedException("Id should not be null");
        }

        Category category = getById(categoryDTO.getId());
        getByName(categoryDTO.getName());

        category.setName(categoryDTO.getName());
        mapper.toDto(categoryRepository.save(category));
        return new MessageResponse("Category updated successfully");
    }


    @Override
    public MessageResponse removeCategory(Long categoryId) {
        Category category = getById(categoryId);
        categoryRepository.delete(category);
        return new MessageResponse("Category was deleted success");
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
    }

    public void getByName(String name) {
        Category category = categoryRepository.findByName(name);
        String foundName = category.getName();
        if (name.equals(foundName)) {
            throw new CategoryOperationNotSupportedException("Category already exists");
        }
    }
}
