package Plante.Class;

public class Plante {

    private String name, couleur, type;
    private float hauteur;

    public Plante(String name, String couleur, float hauteur) {
        this.name = name;
        this.type = "plante";
        this.couleur = couleur;
        this.hauteur = hauteur;
    }

    /** Affiche les informations de la plante
     * @return {String} Informations de la plantes
     */
    public String getInformations(){
        return "Votre "+ this.type + " " + this.name + " de couleur " + this.couleur + " de " + this.hauteur + "m";
    }

    // GETTER SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
}
