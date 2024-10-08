package az.edu.itbrains.blog.mapper;

import az.edu.itbrains.blog.dtos.category.CategoryDTO;
import az.edu.itbrains.blog.models.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDto(Category category);

    List<CategoryDTO> toDto(List<Category> categories);

    Category toEntity(CategoryDTO dto);


}
