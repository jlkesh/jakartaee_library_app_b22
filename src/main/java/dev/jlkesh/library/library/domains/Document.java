package dev.jlkesh.library.library.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {
    private Integer id;
    private String generatedFileName;
    private String originalFileName;
    private String mimeType;
    private String filePath;
    private long fileSize;
    private String extension;
}
