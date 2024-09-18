package org.example.layout;

import lombok.Data;
import org.example.Entity.Calcul;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.Arrays;

@Data
public class CalculatriceChiffre {

    private JPanel jPanel;
    private Calcul calcul;
    public CalculatriceChiffre(){

        jPanel = new JPanel(new GridLayout(3,3));
        jPanel.setBackground(Color.LIGHT_GRAY);
        jPanel.setPreferredSize(new Dimension(JPanel.WIDTH,120));
        calcul = new Calcul();

        for (int i = 1; i < 10; i++) {
            jPanel.add(new JButton(Integer.toString(i)));
        }

        jPanel.add(new JButton("0"));
        jPanel.add(new JButton(","));

    }
}
