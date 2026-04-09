package com.security.springsecurity.contorller;

import com.security.springsecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsCollector {

    private List<Student> listOfStudents = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return listOfStudents;
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        listOfStudents.add(student);
        return student;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
