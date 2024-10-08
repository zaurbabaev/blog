package az.edu.itbrains.blog.controllers;

import az.edu.itbrains.blog.dtos.category.CategoryDTO;
import az.edu.itbrains.blog.payloads.ApiPayload;
import az.edu.itbrains.blog.payloads.ApiResponse;
import az.edu.itbrains.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<ApiPayload<List<CategoryDTO>>> getAll() {
        ApiPayload<List<CategoryDTO>> categories = service.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody CategoryDTO dto) {
        ApiResponse category = service.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }


}
