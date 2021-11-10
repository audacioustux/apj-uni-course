package com.audacioustux.model;

import java.util.*;

public class Account {
    private UUID id;
    private String username;
    private String email;
    private String password;

    public Account(UUID id) {
        this.id = id;
    }

    public Account(UUID id, String username, String email, String password) {
        this(id);
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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
