package com.example.todo_management.exception;

public class UserDuplicateNameException extends RuntimeException{
    public UserDuplicateNameException(String message){
        super(message);
    }
}
