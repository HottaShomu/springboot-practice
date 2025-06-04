package com.example.todo_management.controller;

import com.example.todo_management.entity.Todo;
import com.example.todo_management.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.todo_management.form.TodoForm;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String todos(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todo/todo-list";
    }

    @GetMapping("/new")
    public String todoForm(Model model){
        TodoForm todoForm = new TodoForm();
        model.addAttribute("todoForm", todoForm);
        return "todo/todo-form";
    }

    @PostMapping("/new")
    public String createTodo(TodoForm todoForm, Model model){
        todoService.createTodo(todoForm);

        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todo/todo-list";
    }
}