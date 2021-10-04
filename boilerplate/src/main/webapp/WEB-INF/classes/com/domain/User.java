package com.domain;

public class User {

    private int id;
    private String name;
    private String email;
    private boolean isVip;

    public User() {
    }

    public User(int id, String name, String email, boolean isVip) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isVip = isVip;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsVip() {
        return isVip;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", name: " + name + ", email: " + email + "}";
    }
}