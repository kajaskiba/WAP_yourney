package com.uep.wap.service;

import com.uep.wap.repository.StudentRepository;
import com.uep.wap.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(StudentDTO studentDTO) {
        User user = new User();
        user.setName(studentDTO.getName());
        user.setPoints(studentDTO.getPoints());
        studentRepository.save(user);
        System.out.println("Students added!");
    }

    public Iterable<User> getAllStudents() {
        return studentRepository.findAll();
    }

}
