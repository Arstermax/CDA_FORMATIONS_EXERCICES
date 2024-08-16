package Ihm;

import Utils.DatabaseManager;

import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IhmGlobal {
    int choice=6;
    Scanner scanner = new Scanner(System.in);
    public Connection connection;

    IhmZoo ihmZoo = new IhmZoo();

    public IhmGlobal() throws SQLException, ConnectException {
        try {
            connection = DatabaseManager.getConnection();
            try {
                if (connection != null) System.out.println("Connexion réussi");
            } catch (Error e) {
                throw new ConnectException("Votre Connexion n'a pas pu ce faire!!!");
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public int menu() {
        System.out.println(
                """
                           Veuillez choisir votre exercice avec la JCBD
                           --------------------------------------------
                           1 |- Exercice sur les films
                           2 |- Exercice sur le Zoo
                           0 |- Arrêtez le programme
                          ---------------------------------------------                         
                        """
        );
        choice = scanner.nextInt();
        return choice;
    }

    public void SelectMenu() throws SQLException {
        do {
            switch (choice) {
                case 1 -> choice = 6;
                case 2 -> choice = ihmZoo.getIhmZoo(scanner);
                default -> System.out.println(choice = menu());
            }
        } while (choice != 0);
        System.out.println("Arrêt du programme");
    }
}
