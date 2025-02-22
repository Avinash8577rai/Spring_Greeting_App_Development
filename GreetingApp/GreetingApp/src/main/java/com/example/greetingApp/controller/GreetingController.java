package com.example.greetingApp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // GET Request - Default Greeting
    @GetMapping
    public String getGreeting() {
        return "{ \"message\": \"Hello, Welcome to the Greeting App Using SpringBoot!\" }";
    }
}
