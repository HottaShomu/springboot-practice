package com.example.todo_management.form;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class TodoForm{
    private String task;
    private List<String> categorys;
    private LocalDate deadline;
    private String place;
    private String memo;
    
}