package dev.jlkesh.library.library.domains;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedAt;
    private int pages;
    private int downloads;
    private int views;
    private int likes;
    private int dislikes;
    private String category;
    private boolean deleted;
    private Integer coverId;
    private Integer documentId;
}
