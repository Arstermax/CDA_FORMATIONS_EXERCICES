package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calcul {

    private double montant;
    private double newMontant;
    private String lastOperation;



    private void plus (double newMontant){
        this.montant += newMontant;
    }

    private void moins(double newMontant){
        this.montant -= newMontant;
    }
}
