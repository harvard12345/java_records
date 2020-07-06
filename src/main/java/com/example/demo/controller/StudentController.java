package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("students")
    public List<Student> findAll(){
        return this.studentService.findAll();
    }

    @GetMapping("students/{username}")
    public Student findById(@PathVariable String username){
        return this.studentService.findById(username);
    }

    @DeleteMapping("students/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String username){
        this.studentService.delete(username);
    }

    @PutMapping("students/{username}")
    public void update(@RequestBody Student student, @PathVariable String username){
        this.studentService.update(student, username);
    }

    @PostMapping("studentCreate")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Student student){
        this.studentService.create(student);
    }

}
