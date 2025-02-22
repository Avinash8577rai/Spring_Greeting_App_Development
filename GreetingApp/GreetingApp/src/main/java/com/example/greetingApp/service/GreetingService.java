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

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public Greeting updateGreeting(Long id, String newMessage) {
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));

        existingGreeting.setMessage(newMessage);
        return greetingRepository.save(existingGreeting);
    }

    public void deleteGreeting(Long id) {
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));

        greetingRepository.delete(existingGreeting);
    }
}

