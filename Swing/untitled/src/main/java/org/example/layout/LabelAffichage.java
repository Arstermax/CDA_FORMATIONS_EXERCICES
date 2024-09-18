package org.example.layout;

import lombok.Data;
import org.example.Entity.Calcul;

import javax.swing.*;
import java.awt.*;

@Data
public class LabelAffichage {
    private JLabel jLabel;

    public LabelAffichage(){
        Calcul calcul = new Calcul();
        calcul.setMontant(0);
        jLabel = new JLabel(Double.toString(calcul.getMontant()));
    }
}
