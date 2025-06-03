package com.example.todo_management.repository;

import com.example.todo_management.mapper.TodoMapper;
import com.example.todo_management.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {
    private final TodoMapper todoMapper;

    public TodoRepository(TodoMapper todoMapper){
        this.todoMapper = todoMapper;
    }

    public List<Todo> getAllTodos(){
        return todoMapper.selectAllTodos();
    }
}