package com.example.todo_management.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class Todo {
    private long id;
    private String task;
    private String category;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private String place;
    private String memo;
    private LocalDateTime createdAt;
    private boolean isTodoflag;
    
}