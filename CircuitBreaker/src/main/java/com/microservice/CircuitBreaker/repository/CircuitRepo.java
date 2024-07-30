package com.microservice.CircuitBreaker.repository;

import com.microservice.CircuitBreaker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircuitRepo extends JpaRepository<User, Integer> {
}
