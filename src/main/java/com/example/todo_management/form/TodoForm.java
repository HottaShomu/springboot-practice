package com.example.todo_management.form;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TodoForm{
    private String task;
    private String category;
    private LocalDate deadline;
}