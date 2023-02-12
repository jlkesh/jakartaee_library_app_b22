package dev.jlkesh.library.library.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private Status status;
    private LocalDateTime blockedTill;

    public enum Status {
        NOT_ACTIVE,
        ACTIVE,
        BLOCKED
    }
}
