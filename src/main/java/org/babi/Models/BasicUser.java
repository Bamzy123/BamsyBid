package org.babi.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "basicUsers")
public class BasicUser extends User {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
    private boolean banned = false;

    @Override
    public boolean isBanned() {
        return banned;
    }

    @Override
    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}
