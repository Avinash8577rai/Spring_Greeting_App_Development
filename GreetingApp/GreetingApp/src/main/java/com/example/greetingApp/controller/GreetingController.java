package com.example.greetingApp.controller;

import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor Injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET Request - Using Service Layer
    @GetMapping
    public String getGreeting() {
        return "{ \"message\": \"" + greetingService.getGreetingMessage() + "\" }";
    }
}

