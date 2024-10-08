package az.edu.itbrains.blog.dtos.article;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleUpdateDTO {
    Long id;
}
