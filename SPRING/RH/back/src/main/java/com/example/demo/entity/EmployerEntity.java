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
@Table(name = "employer")
public class EmployerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String identificationNumber;
    private String address;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    private String occupation;
    private String password;
    private boolean role;
    private double salary;
    private String observation;
}
