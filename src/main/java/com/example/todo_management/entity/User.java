package com.example.todo_management.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    public class users {
    private long userId;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    }
}
