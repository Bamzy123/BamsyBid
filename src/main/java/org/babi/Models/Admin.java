package org.babi.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
public class Admin extends User{
    public Admin(String username, String password) {
        super();
    }
}
