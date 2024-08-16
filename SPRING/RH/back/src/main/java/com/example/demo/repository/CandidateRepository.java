package com.example.demo.repository;

import com.example.demo.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity,Long> {
}
