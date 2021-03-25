package com.example.backend.controller;

import com.example.backend.AppException;
import com.example.backend.model.Student;
import com.example.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    public StudentRepository repository;

    @CrossOrigin
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student user) {
        StudentRepository s = new StudentRepository();
        s.saveStudent(user);
        return ResponseEntity.ok("SUCCESS");
    }

    @CrossOrigin
    @GetMapping("/getStudent")
    public ResponseEntity<List<Student>> getAllStudent() {
        StudentRepository s = new StudentRepository();
        return ResponseEntity.ok(s.getAllStudent());
    }

    @CrossOrigin
    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable String id) {
        try{
            return repository.getStudentById(id);
        } catch (AppException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No Data Exist");
        }
    }

    @CrossOrigin
    @PostMapping("/addCustomStudent")
    public ResponseEntity<String> addCustomStudent(@RequestBody Student user) {
        repository.addStudent(user);
        return ResponseEntity.ok("SUCCESS");
    }

}
