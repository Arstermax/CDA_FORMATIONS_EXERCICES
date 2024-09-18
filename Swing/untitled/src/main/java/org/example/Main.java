package org.example;

import org.example.layout.CalculatriceChiffre;
import org.example.layout.LabelAffichage;

import javax.swing.*;
import java.awt.*;

import static java.awt.Label.CENTER;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Exercice 1");
        jFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        jFrame.add(new LabelAffichage().getJLabel(), gbc);

        jFrame.add(new CalculatriceChiffre().getJPanel(), gbc);

        jFrame.setSize(1200, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        jFrame.setVisible(true);
    }
}