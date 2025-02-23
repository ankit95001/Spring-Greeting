package com.bridgelabz.greeting.beans;

import com.bridgelabz.greeting.dto.Student;
import com.bridgelabz.greeting.entities.Employee;
import com.bridgelabz.greeting.services.EmployeeService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Student student(){
        return new Student();
    }

    @Bean
    public Employee employee(){
        return new Employee();
    }
}
