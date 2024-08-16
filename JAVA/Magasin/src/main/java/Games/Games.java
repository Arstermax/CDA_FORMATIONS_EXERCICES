package Games;

import Games.Class.Personnage;

public class Games {
    public int play(){
        Personnage Joueur1 = new Personnage("Alex",100, 80,60,20);
        Personnage Joueur2 = new Personnage("Eric",100, 40,60,20);

        System.out.println(Joueur1.getAttck(Joueur2));
        System.out.println(Joueur2.getLife() + " HP");
        return 5;
    }
}
