package com.example.ashley.mentormatch;

import java.util.HashMap;
import java.util.List;

public class User {

    private String username;
    private String email;
    private String profilePicLocation;

    public User(){

    }

    public User(String name, String email){
        this.username = name;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) { this.email = email; }

    public String getProfilePicLocation() {
        return profilePicLocation;
    }

}
