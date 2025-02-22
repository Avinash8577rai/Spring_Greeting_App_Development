package com.example.greetingApp.service;

import org.springframework.stereotype.Service;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.repository.GreetingRepository;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }
}

