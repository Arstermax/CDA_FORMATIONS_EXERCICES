package org.example.exercice02Film.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@Builder
@Getter
@Setter
@Data
public class Film {
    private int id;
    private String titre,realisateur,genre;

    public Film( int id,String titre, String realisateur, String genre) {
        this.id = id;
        this.titre = titre;
        this.realisateur = realisateur;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public void afficher() {
        System.out.println(this);
    }
}
