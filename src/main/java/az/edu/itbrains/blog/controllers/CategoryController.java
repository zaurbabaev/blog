package az.edu.itbrains.blog.controllers;

import az.edu.itbrains.blog.dtos.category.CategoryDTO;
import az.edu.itbrains.blog.payloads.ApiPayload;
import az.edu.itbrains.blog.payloads.MessageResponse;
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
    public ResponseEntity<MessageResponse> create(@RequestBody CategoryDTO dto) {
        MessageResponse category = service.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Object> update(@RequestBody CategoryDTO categoryDTO) {
        MessageResponse message = service.updateCategory(categoryDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<MessageResponse> delete(@PathVariable("categoryId") Long id){
        MessageResponse messageResponse = service.removeCategory(id);
        return new ResponseEntity<>(messageResponse,HttpStatus.OK);
    }



}
