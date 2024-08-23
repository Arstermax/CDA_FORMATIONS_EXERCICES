package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpruntDto {
    private long id;
    private String libelle;
    private String empruntNumber;
    private double montant;
}
