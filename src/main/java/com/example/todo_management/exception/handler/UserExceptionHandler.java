package com.example.todo_management.exception.handler;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.todo_management.exception.UserDuplicateNameException;

@ControllerAdvice
public class UserExceptionHandler {
    
    @ExceptionHandler(UserDuplicateNameException.class)
    public String handleUserDuplicateNameException(UserDuplicateNameException e, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error","既に登録されているユーザーネームです");
        return "redirect:/register";
    }
}
