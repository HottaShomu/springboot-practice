package com.example.todo_management.form;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class TodoForm{
    private String task;
    private String category;
    private LocalDate deadline;
    private LocalTime startTime;
    private LocalTime endTime;
    private String place;
    private String memo;

}