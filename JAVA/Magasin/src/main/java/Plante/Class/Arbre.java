package Plante.Class;

public class Arbre extends Plante{
    float circonferences;

    public Arbre(String name, String couleur, float hauteur, float circonferences) {
        super(name, couleur, hauteur);
        super.setType("Arbres");
        this.circonferences = circonferences;
    }


    public String getInformations(){
        return super.getInformations() + " Le périmètre du tronc est de " + this.circonferences;
    }
}
