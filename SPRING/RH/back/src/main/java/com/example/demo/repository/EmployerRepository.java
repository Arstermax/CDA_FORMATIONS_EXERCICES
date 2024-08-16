package com.example.demo.repository;

import com.example.demo.entity.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {
}
