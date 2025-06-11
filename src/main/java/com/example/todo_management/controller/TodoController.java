package com.example.todo_management.controller;

import com.example.todo_management.entity.Todo;
import com.example.todo_management.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/Done")
    public String Dones(Model model){
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "done/done-list";
    }

    @GetMapping("/new")
    public String todoForm(Model model){
        TodoForm todoForm = new TodoForm();
        model.addAttribute("todoForm", todoForm);
        return "todo/todo-form";
    }

    @PostMapping("/new")
    public String createTodo(TodoForm todoForm){
        todoService.createTodo(todoForm);

        //List<Todo> todos = todoService.getAllTodos();
        //model.addAttribute("todos", todos);
        //return "todo/todo-list";
        return "redirect:/todos";
    }

    @PostMapping("/{id}/delete/{isTodoflag}")
    public String changeFlag(@PathVariable long id, @PathVariable boolean isTodoflag){
        todoService.changeFlag(isTodoflag, id);
        return "redirect:/todos";
    }

    @GetMapping("/{id}/edit")
    public String editTodo(@PathVariable long id, Model model){
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);

        return "todo/todo-edit";
    }

    @PostMapping("/{id}/edit")
    public String updateTodo(@PathVariable long id, Todo todo){
        todoService.updateTodo(id,todo);
        return "redirect:/todos";
    }
}