package com.example.todo_management.mapper;

import com.example.todo_management.entity.Todo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todos WHERE isTodoflag = #{isTodoflag}")
    List<Todo> selectAllTodos(boolean isTodoflag);

    @Insert("INSERT INTO todos (task, deadline, category) VALUES (#{task}, #{deadline}, #{category})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTodo(Todo todo);

    @Delete("DELETE FROM todos WHERE id = #{id}")
    void deleteTodoById(long id);

    @Update("UPDATE todos SET task = #{task}, deadline = #{deadline}, category = #{category} WHERE id = #{id}")
    void updateTodo(Todo todo);

    @Select("SELECT * FROM todos WHERE id = #{id}")
    Todo selectTodoById(long id);
}