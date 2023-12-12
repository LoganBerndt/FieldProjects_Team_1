package com.example.ymca_fieldproject_backend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Devin Johnson
// 12/12/2023
// Users object
@Entity
@Table(name = "ymca_fieldproject_database")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    @NotBlank(message = "Username is required")
    @Column(name = "username")
    @Size(max=25)
    private String username;

    @NotBlank(message = "Password is required")
    @Column(name = "password")
    @Size(max=25)
    private String password;

    @NotBlank(message = "Email is required")
    @Column(name = "email")
    @Size(max=30)
    @Email
    private String email;

    public User(long user_id, String username, String password, String email) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {

    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
