package com.example.greetingApp.controller;

import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET Request with Query Parameters
    @GetMapping
    public String getGreeting(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {

        return "{ \"message\": \"" + greetingService.getGreetingMessage(firstName, lastName) + "\" }";
    }
}

