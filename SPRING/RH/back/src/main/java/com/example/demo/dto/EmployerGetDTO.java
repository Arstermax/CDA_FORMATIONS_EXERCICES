package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerGetDTO {
    private String name;
    private String identificationNumber;
    private String address;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    private String occupation;
    private boolean admin;
    private double salary;
    private String observation;
}
