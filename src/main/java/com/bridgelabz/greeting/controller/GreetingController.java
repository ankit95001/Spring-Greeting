package com.bridgelabz.greeting.controller;

import com.bridgelabz.greeting.dto.Student;
import com.bridgelabz.greeting.entities.Greeting;
import com.bridgelabz.greeting.services.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {
    private final Student student;
    private final GreetingService greetingService;

    public GreetingController(Student student, GreetingService service){
        this.student=student;
        this.greetingService=service;
    }
    @GetMapping("/greeting")
    public Student sayHello(){
        student.setRollNumber(5);
        student.setFirstName("Ankit");
        student.setLastName("Kumar");
        return student;
    }

    @PostMapping("/greeting")
    public String createStudent(@RequestBody Student newStudent) {
        return "Student created: " + newStudent;
    }

    @PutMapping("/greeting")
    public String updateStudent(@RequestBody Student updatedStudent) {
        return "Student updated: " + updatedStudent;
    }

    @DeleteMapping("/greeting")
    public String deleteStudent() {
        return "Student deleted";
    }

    @GetMapping("/greet")
    public String getGreeting() {
        return greetingService.getGreetingMessage()+" "+student.getFirstName();
    }

    @GetMapping("/greetparam")
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    @GetMapping("/greetdb")
    public String getGreetingMessage(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessageFromDB(firstName, lastName);
    }

    @GetMapping("/greetdb/{id}")
    public Greeting getGreetingMessageFromDB(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/greetdb/all")
    public List<Greeting> getGreetingMessageFromDBAll(){
        return greetingService.getAllGreeting();
    }

    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        return greetingService.updateGreeting(id, updatedGreeting.getMessage());
    }

    @DeleteMapping("/greetDBDelete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Greeting with ID " + id + " deleted successfully!";
    }
}














