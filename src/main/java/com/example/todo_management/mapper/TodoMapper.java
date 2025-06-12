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

    @Select("SELECT * FROM todos")
    List<Todo> selectAllTodos();

    @Insert("INSERT INTO todos (task, deadline, category, place, memo) VALUES (#{task}, #{deadline}, #{category}, #{place}, #{memo})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTodo(Todo todo);

    @Delete("DELETE FROM todos WHERE id = #{id}")
    void deleteTodoById(long id);

    @Update("UPDATE todos SET task = #{task}, deadline = #{deadline}, category = #{category}, place = #{place}, memo = #{memo} WHERE id = #{id}")
    void updateTodo(Todo todo);

    @Select("SELECT * FROM todos WHERE id = #{id}")
    Todo selectTodoById(long id);

    @Update("UPDATE todos SET isTodoflag = #{isTodoflag} WHERE id = #{id}")
    void updateFlag(boolean isTodoflag, long id);
}