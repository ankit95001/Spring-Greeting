package com.bridgelabz.greeting.controller;

import com.bridgelabz.greeting.dto.Student;
import com.bridgelabz.greeting.services.GreetingService;
import org.springframework.web.bind.annotation.*;

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

}
