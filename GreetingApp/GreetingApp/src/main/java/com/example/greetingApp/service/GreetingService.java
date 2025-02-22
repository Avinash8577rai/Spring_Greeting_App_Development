package com.example.greetingApp.service;

import org.springframework.stereotype.Service;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.repository.GreetingRepository;
import java.util.Optional;
import java.util.List;


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

    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, String newMessage) {
        return greetingRepository.findById(id)
                .map(existingGreeting -> {
                    existingGreeting.setMessage(newMessage);
                    return greetingRepository.save(existingGreeting);
                })
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }
}
