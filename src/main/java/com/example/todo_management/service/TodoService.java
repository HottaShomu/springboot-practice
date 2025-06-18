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

    public List<Todo> getAllTodos(long userId){
        return todoRepository.getAllTodos(userId);
    }

    public void createTodo(TodoForm todoForm,long userId){
        Todo todo = new Todo();
        todo.setTask(todoForm.getTask());
        todo.setCategory(todoForm.getCategory());
        todo.setDeadline(todoForm.getDeadline());
        todo.setStartTime(todoForm.getStartTime());
        todo.setEndTime(todoForm.getEndTime());
        todo.setPlace(todoForm.getPlace());
        todo.setMemo(todoForm.getMemo());
        todo.setUserId(userId);
        todo.setPriority(todoForm.getPriority());
        
        todoRepository.insertTodo(todo);
    }

    public void deleteTodo(long id){
        todoRepository.deleteTodo(id);
    }

    public Todo getTodoById(long id){
        return todoRepository.getTodoById(id);
    }

    public void updateTodo(long id, Todo todo){
        if (id != todo.getId()){
            throw new IllegalArgumentException("Todo ID does not match");
        }
        todoRepository.updateTodo(todo);
    }

    public void changeFlag(boolean isTodoflag, long id) {
        Todo todo = new Todo();
        if (todo.isTodoflag() == false) {
            isTodoflag = !isTodoflag;
        }else if(todo.isTodoflag() == true){
             isTodoflag = !isTodoflag;
        }
        todoRepository.updateFlag(isTodoflag, id);
    }
}
