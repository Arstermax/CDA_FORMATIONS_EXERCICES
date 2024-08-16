package org.example.exercice02Film;


import org.example.exercice02Film.Utils.Ihm;
import org.example.exercice02Film.entity.Film;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        Ihm ihm = new Ihm();
        ihm.start();
    }
}
