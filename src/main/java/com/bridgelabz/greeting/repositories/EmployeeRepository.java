package com.bridgelabz.greeting.repositories;

import com.bridgelabz.greeting.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

