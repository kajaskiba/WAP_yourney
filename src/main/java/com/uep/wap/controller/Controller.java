package com.uep.wap.controller;

import com.uep.wap.dto.StudentDTO;
import com.uep.wap.dto.StudentsDataDTO;
import com.uep.wap.model.Student;
import com.uep.wap.service.StudentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class Controller {

    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/hello")
    public String sayHello(){
        return "Hello!";
    }

    @GetMapping(path = "/students")
    public Iterable<User> getAllStudents(){
        return userService.getAllStudents();
    }

    @PostMapping(path = "/students")
    public String addStudents(@RequestBody UserDTO studentDTO){
        userService.addUser(UserDTO);
        return "Users added!";
    }

}