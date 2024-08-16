package org.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Livre {
    private String titre, auteur, realisateur, date;
    boolean abonnement;

    public Livre(String titre, String auteur, String realisateur, String date, boolean abonnement) {
        this.titre = titre;
        this.auteur = auteur;
        this.realisateur = realisateur;
        this.date = date;
        this.abonnement = abonnement;
    }

}
