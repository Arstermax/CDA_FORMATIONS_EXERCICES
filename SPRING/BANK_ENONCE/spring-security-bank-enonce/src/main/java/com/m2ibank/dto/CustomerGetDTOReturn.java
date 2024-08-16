package com.m2ibank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerGetDTOReturn {
    private int id;
    private String name;
    private String email;
    private String role;
}
