package com.example.todo_management.mapper;

import com.example.todo_management.entity.Todo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todos")
    List<Todo> selectAllTodos();

    @Insert("INSERT INTO todos (task, deadline, category) VALUES (#{task}, #{deadline}, #{category})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTodo(Todo todo);
}