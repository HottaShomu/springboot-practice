package com.example.todo_management.service;

import org.springframework.stereotype.Service;
import com.example.todo_management.entity.Todo;
import com.example.todo_management.form.TodoForm;
import com.example.todo_management.repository.TodoRepository;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.getAllTodos();
    }

    public void createTodo(TodoForm todoForm){
        Todo todo = new Todo();
        todo.setTask(todoForm.getTask());
        todo.setCategory(todoForm.getCategory());
        todo.setDeadline(todoForm.getDeadline());
        todoRepository.insertTodo(todo);
    }

    
}
