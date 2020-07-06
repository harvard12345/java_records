package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final JdbcTemplate jdbcTemplate;

    public StudentService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Student student) {
        jdbcTemplate.update("insert into school.student(username, password) value (?, ?)", student.username(), student.password());
    }

    public List<Student> findAll() {
        return this.jdbcTemplate.query("select * from school.student", (rs, rowNum) -> new Student(rs.getString("username"), rs.getString("password")));
    }

    public Student findById(String username) {
        RowMapper<Student> rowMapper = (rs, rowNum) -> new Student(rs.getString("username"), rs.getString("password"));
        return this.jdbcTemplate.queryForObject("select * from school.student where username = ? limit 1", new Object[]{username}, rowMapper);
    }

    public void delete(String username){
        this.jdbcTemplate.update("delete from school.student where username = ?", username);
    }

    public void update(Student student, String username){
        this.jdbcTemplate.update("update school.student set username = ?, password = ? where username = ?", student.username(), student.password(), username);
    }


}
