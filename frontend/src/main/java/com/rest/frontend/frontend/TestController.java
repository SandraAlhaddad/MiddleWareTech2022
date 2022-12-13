package com.rest.frontend.frontend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String displayPage() {

        String test = WebClient
                .create("http://localhost:8080/StdController/Welcome")
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return test;
    }

}
