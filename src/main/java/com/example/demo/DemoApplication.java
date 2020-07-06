package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final StudentService studentService;

    public DemoApplication(StudentService studentService){
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Stream.of(
                new Student("jane","jane12345"),
                new Student("john","john12345"),
                new Student("jack","jack12345"),
                new Student("bill","bill12345"),
                new Student("gate","gate12345")).
                forEach(studentService::create);
    }
}
