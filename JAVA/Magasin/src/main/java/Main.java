import CompteBancaire.CompteBancaireMain;
import Games.Games;
import Plante.PlanteGames;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 5;
        Games games = new Games();
        PlanteGames planteGames = new PlanteGames();
        CompteBancaireMain compteBancaireMain = new CompteBancaireMain();

        do {
            switch (choice) {
                case 1:
                    choice = games.play();
                    break;
                case 2:
                    choice = planteGames.Play(scanner);
                    break;
                case 3:
                    choice = compteBancaireMain.play(scanner);
                    break;
                default:
                    System.out.println("Quel jeu voulez-vous jouer?");
                    System.out.println("1 - Games\n2 - Jardilande\n3 - Compte Bancaire\n0 - Arrêt le programme");
                    choice = scanner.nextInt();
            }
        }
        while (choice != 0);

        System.out.println("--------------------");
        System.out.println(" Merci et à Bientôt ");
        System.out.println("--------------------");

    }
}
