package az.edu.itbrains.blog.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "articles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    @Column(columnDefinition = "text")
    String description;

    LocalDateTime createdDate;

    LocalDateTime updateDate;

    @ManyToOne
    Category category;
}
