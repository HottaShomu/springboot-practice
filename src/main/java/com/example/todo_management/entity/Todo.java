package com.example.todo_management.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class Todo {
    private long id;
    private String task;
    private String category;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private LocalTime startTime;
    private LocalTime endTime;
    private String place;
    private String memo;
    private LocalDateTime createdAt;
    private boolean isTodoflag;
    private long userId;
}