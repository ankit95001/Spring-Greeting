package com.bridgelabz.greeting.repositories;

import com.bridgelabz.greeting.entities.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {
}
