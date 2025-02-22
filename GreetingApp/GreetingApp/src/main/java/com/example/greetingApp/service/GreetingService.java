package com.example.greetingApp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreetingMessage() {
        return "Hello in World of programming!";
    }
}
