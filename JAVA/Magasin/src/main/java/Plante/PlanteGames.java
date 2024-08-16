package Plante;

import Plante.Class.Arbre;
import Plante.Class.Plante;

import java.util.Scanner;

public class PlanteGames {

    public int Play(Scanner scanner) {

        String name, couleur;
        int choice = 5;
        float hauteur, circonferences;

        System.out.println("-------------------------");
        System.out.println(" Programmes des Plantes ");
        System.out.println("-------------------------");

        do {
            switch (choice) {
                case 1:
                    System.out.println("Vous souhaiter voir pour une plante");

                    System.out.println("Quel est le nom de votre plante?");
                    name = scanner.next();

                    System.out.println("Quel est la taille de votre plante?");
                    hauteur = scanner.nextFloat();

                    System.out.println("Quel est la couleur de votre plante?");
                    couleur = scanner.next();

                    Plante planteSelected = new Plante(name, couleur, hauteur);
                    System.out.println(planteSelected.getInformations());
                    choice = 5;
                    break;
                case 2:

                    System.out.println("Vous souhaiter voir pour un Arbres");
                    System.out.println("Quel est le nom de votre plante?");
                    name = scanner.next();

                    System.out.println("Quel est la couleur de votre arbre?");
                    couleur = scanner.next();

                    System.out.println("Quel est la taille de votre arbre?");
                    hauteur = scanner.nextFloat();

                    System.out.println("Quel est le circonférences de votre arbre?");
                    circonferences = scanner.nextFloat();

                    Arbre arbre = new Arbre(name, couleur, hauteur, circonferences);

                    System.out.println(arbre.getInformations());
                    choice = 5;
                    break;
                default:
                    System.out.println("Selectioner votre choix : ");
                    System.out.println("1 - Ajouter une plante \n2 - Ajouter un Arbre \n0 - Fin du Programme");
                    choice = scanner.nextInt();
                    break;
            }
        } while (choice != 0);


        System.out.println("-------------------------");
        System.out.println("Jeu des Plantes est Terminé !!!");
        System.out.println("-------------------------");
        return 5;
    }
}
