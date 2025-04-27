package org.babi.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "users")
public abstract class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
    private boolean banned = false;
}