package com.example.todo_management.service;

import com.example.todo_management.entity.User;
import com.example.todo_management.exception.UserDuplicateNameException;
import com.example.todo_management.form.UserForm;
import com.example.todo_management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserForm userForm,String username) {    
        User user = new User();
        user.setUsername(userForm.getUsername());
        if(user.getUsername().equals(userRepository.getUsername(username))){
            throw new UserDuplicateNameException("既に使われているユーザーーネームです");
        }
        String hashedPassword = passwordEncoder.encode(userForm.getPassword());
        user.setPassword(hashedPassword);

        userRepository.insertUser(user);
    }


}
