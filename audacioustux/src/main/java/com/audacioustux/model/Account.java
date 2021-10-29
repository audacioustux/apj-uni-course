package com.audacioustux.model;

import java.util.*;

public class Account {
    private UUID id;
    private String username;
    private String email;

    public Account(UUID id) {
        this.id = id;
    }

    public Account(UUID id, String username, String email) {
        this(id);
        this.username = username;
        this.email = email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
