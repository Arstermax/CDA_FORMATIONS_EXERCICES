package com.example.demo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class CandidateGetDTO {
    private String name;
    private String identificationNumber;
    private String address;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private String rating;
    private String observation;
    private String skill;
    private String technicalArea;
    private LocalDate jobInterviewDate;
}
