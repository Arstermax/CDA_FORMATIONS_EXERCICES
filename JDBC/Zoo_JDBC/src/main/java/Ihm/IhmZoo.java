package Ihm;

import Utils.DatabaseManager;
import exercice.Zoo.DAO.AnimalDAO;
import exercice.Zoo.DAO.NourritureDao;
import exercice.Zoo.Entity.Animal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IhmZoo {
    private Connection connection;
    private AnimalDAO animalDAO;
    private NourritureDao nourritureDao;

    int choice = 6;
    public IhmZoo() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try{
            connection = DatabaseManager.getConnection();
             animalDAO = new AnimalDAO(connection);
             nourritureDao = new NourritureDao(connection);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int getIhmZoo(Scanner scanner) throws SQLException {

        String name,habitat, description, race;
        int age;

        do {
            switch (choice) {
                case 1:
                    System.out.println("Quel animal souhaiter vous inscrire?");
                    name = scanner.next();
                    System.out.println("Quel age a votre animal?");
                    age = scanner.nextInt();
                    System.out.println("Dans quel habitat vit-il?");
                    habitat = scanner.next();
                    System.out.println("quel type d'espèce appartient-il?");
                    race = scanner.next();
                    System.out.println("Avez vous une description pour cette animal?");
                    description = scanner.next();
                    Animal animal = Animal.builder()
                            .age(age)
                            .habitat(habitat)
                            .name(name)
                            .race(race)
                            .description(description)
                            .build();
                    animalDAO.Add(animal);
                    choice = 6;
                    break;
                default:
                    System.out.println("""
                            Bienvenue dans l'exercice du zoo ^_^
                            1 |- Ajouter un animaux à la bases de données
                            2 |- Récupérer les animaux de la bases de données  
                            0 |- Arrêt de l'app du Zoo 
                            """);
                    choice = scanner.nextInt();
                    break;
            }
        } while (choice != 0);
        System.out.println("fin du programme pour le zoo");
        return 6;
    }
}
