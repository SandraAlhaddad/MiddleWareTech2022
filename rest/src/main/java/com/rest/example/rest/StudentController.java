package com.rest.example.rest;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/StdController")
public class StudentController {

    Map<String, Student> students = new HashMap<>();

    @GetMapping("/Welcome")
    public String Welcome() {
        return "Welcome to HFT Stuttgart!";
    }

    @Operation(summary = "Create new student account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student account has been created", content = @Content)
    })
    @PostMapping("student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student CreateAccountStudent(@RequestBody Student student) {
        students.put(student.getId(), student);
        return student;
    }

    @GetMapping("student")
    public Student getStudent(@RequestParam String Id) {
        return students.get(Id);
    }

    @GetMapping("firststudent")
    public Student getFirstStudent() {
        return students.get("1");
    }

    @Operation(summary = "Return a list of all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all students", content = @Content)
    })
    @GetMapping("students")
    public List<Student> getAllStudents() {
        return students.values().stream().toList();
    }

    @PutMapping("setSpecialization")
    public Student setStudentSpec(@RequestParam String Id, String specialization) {
        Student student = students.get(Id);
        student.setSpecialization(specialization);
        students.put(Id, student);
        return student;
    }

    @DeleteMapping("deleteStudent")
    public Student deleteStudent(@RequestParam String Id) {
        Student student = students.get(Id);
        students.remove(Id);
        return student;
    }
}