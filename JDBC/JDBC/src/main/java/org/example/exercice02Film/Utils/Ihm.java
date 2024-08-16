package org.example.exercice02Film.Utils;

import lombok.Setter;
import org.example.exercice02Film.DAO.FilmDAO;
import org.example.exercice02Film.entity.Film;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Setter
public class Ihm {

    private int id;
    private String titre, realisateur, genre, newtitre;
    private Connection connection;
    private FilmDAO filmDAO;

    private Scanner scanner = new Scanner(System.in);

    public Ihm() throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            filmDAO = new FilmDAO(connection);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void start() throws SQLException {
        int entry = 0;

        do {
            switch (entry) {
                case 1:
                    System.out.println("Votre nom de film:");
                    setTitre(scanner.next());
                    System.out.println("Votre nom de réalisateur:");
                    setRealisateur(scanner.next());
                    System.out.println("Votre genre:");
                    setGenre(scanner.next());
                    filmDAO.createFilm(this.titre, this.realisateur, this.genre);
                    entry = 6;
                    break;
                case 2:
                    getAllFilm();
                    entry = 6;
                    break;
                case 3:
                    System.out.println("Quel est le numéro de celui auquel vous voulez modifier le titre?");
                    id = scanner.nextInt();
                    System.out.println("Quel sera le titre en question?");
                    newtitre = scanner.next();
//                    updateTitre(newtitre,id);
                    entry = 6;
                    break;
                default:
                    System.out.println(
                            "--- Gestion de Film ---" +
                                    "\n------------------" +
                                    "\n1/ Création de film" +
                                    "\n2/ Afficher tous les films" +
                                    "\n3/ Mettre à jour un titre de films" +
                                    "\n0/ fin du programme");
                    entry = scanner.nextInt();
            }

        } while (entry != 0);
        System.out.println("Fin du programme");
    }

//    private void updateTitre(String title, int id) {
//        try {
////            String films = filmDAO.updateTitle(title, id);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private void getAllFilm() {
        try {
            List<Film> films = filmDAO.getAllFilm();
            for (Film film : films) {
                System.out.println(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
