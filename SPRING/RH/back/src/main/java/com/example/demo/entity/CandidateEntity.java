package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
