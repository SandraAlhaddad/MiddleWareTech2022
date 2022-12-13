package com.rest.frontend.frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v2")
public class FrontendController {

    @Value("${backend.endpoint}")
    private String StudentApiEndpoint;

    @GetMapping()
    public String displayPage(Model model) {

        Student[] students = WebClient
                .create(StudentApiEndpoint)
                .get()
                .retrieve()
                .bodyToMono(Student[].class)
                .block();
        model.addAttribute("students", students);

        return "page";
    }

    @PostMapping("/create")
    public String addStudent(@RequestParam String name, @RequestParam String id, @RequestParam String specialization,
            Model model) {

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSpecialization(specialization);

        WebClient
                .create(StudentApiEndpoint)
                .post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(student), Student.class)
                .retrieve()
                .bodyToMono(Student.class)
                .block();

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam String id) {

        WebClient
                .create(StudentApiEndpoint + id)
                .delete()
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return "redirect:/";

    }
}