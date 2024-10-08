package az.edu.itbrains.blog.mapper;

import az.edu.itbrains.blog.dtos.article.ArticleDTO;
import az.edu.itbrains.blog.models.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleDTO toDtO(Article article);

    List<ArticleDTO> toDto(List<Article> articles);

    Article toEntity(ArticleDTO dto);
}
