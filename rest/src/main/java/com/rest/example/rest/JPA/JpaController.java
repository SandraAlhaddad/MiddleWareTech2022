package com.rest.example.rest.JPA;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/jpa/")
public class JpaController {

    @Autowired
    StudentRepository studentRepository;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "student has been created", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{name}")
    public StudentJpa createAndAddStudent(@PathVariable String name) {

        StudentJpa student = new StudentJpa(name);
        studentRepository.save(student);

        return student;
    }

    @GetMapping("/count")
    public long getNumberOfStudents() {

        return studentRepository.count();

    }

    @GetMapping("/id/{id}")
    public Optional<StudentJpa> findById(@PathVariable String id) {

        return studentRepository.findById(id);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(produces = "application/json", path = "/{Id}")
    StudentJpa deleteStudent(@PathVariable String Id) {

        studentRepository.deleteById(Id);

        return null;
    }
}