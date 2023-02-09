package dev.jlkesh.library.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDetailsDTO {
    private Integer id;
    private String title;
    private String author;
    private String description;
    private int views;
    private int likes;
    private int dislikes;
    private int downloads;
    private int pages;
    private String category;
    private String publisher;
    private String coverOriginalFileName;
    private String coverGeneratedFileName;
    private String coverFileSize;
    private String documentOriginalFileName;
    private String documentGeneratedFileName;
    private String documentFileSize;
}
