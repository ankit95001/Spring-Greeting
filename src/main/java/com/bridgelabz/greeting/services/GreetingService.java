package com.bridgelabz.greeting.services;

import com.bridgelabz.greeting.controller.GreetingController;
import com.bridgelabz.greeting.entities.Greeting;
import com.bridgelabz.greeting.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage() {
        return "Hello from Greeting Service";
    }

    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }

    public String getGreetingMessageFromDB(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World!";
        }

        greetingRepository.save(new Greeting(null, message));

        return message;
    }

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }

    public List<Greeting> getAllGreeting(){
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, String newMessage) {
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));

        existingGreeting.setMessage(newMessage);
        return greetingRepository.save(existingGreeting);
    }

    public void deleteGreeting(Long id) {
        if (!greetingRepository.existsById(id)) {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
        greetingRepository.deleteById(id);
    }
}
