package org.example;

public class RealBook implements Book {
    @Override
    public String readBook(Livre Livre) {
        return "Vous lisez le livre" +
                Livre.getTitre() +
                "dont l'auteur est " +
                Livre.getAuteur() +
                "et le réalisateur sont " +
                Livre.getRealisateur();
    }
}
