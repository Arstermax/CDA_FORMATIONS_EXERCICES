package magasin.Class.Magasin;

import java.util.Arrays;

public class Magazin {
    private String name;
    private final int id_Magazin;
    private Produits[] allProduits;

    private static int nbrMagasin;

    public Magazin(String name) {
        this.nbrMagasin++;
        this.id_Magazin = this.nbrMagasin;
        this.name = name;
        this.allProduits = new Produits[4];
    }

    /**
     * Description :
     * Permet de rajouter
     * un produit à l'instance d'un Magasin.
     * @param produits Un produit instancié de la class produits.
     * @param espace   Endroits où se trouve l'id.
     * @return une chaine (Succès | Sois Error)
     */
    public String addProduits(Produits produits, int espace) {
        try {
            this.allProduits[espace] = produits;
            return "Succèes";
        } catch (Exception e) {
            return "Error" + e;
        }
    }

    /**
     * Description :
     * Permet de supprimer un produit d'un magasin.
     * @param index {int} desc : Indique l'endroit du tableau où se trouve le produit.
     * @return {String} [Chaine || Erreur]
     */
    public String removeProduits(int index) {
        String nameProduct = this.allProduits[index].getName();
        try {
            this.allProduits[index] = null;
            return "Votre element" + nameProduct + " à bien été supprimer";
        } catch (Exception e) {
            return "Erreur" + e;
        }
    }

    /**
     * Description : \"
     * Permet d'Obtenir Tous les produits du magasin
     *
     * @return {string} [Les Produits du Magasin | Erreur]
     */
    public String getProduit() {
        String message = "";
        try {
            for (int i = 0; i < this.allProduits.length; i++) {
                message += "Name : " + this.allProduits[i].getName() + " au prix de " + this.allProduits[i].getPrice() + " €" + "\n" + this.allProduits[i].getDescription() + "\n";
            }
            return message;
        } catch (Exception e) {
            message = "Erreur" + e;
            return message;
        }
    }

    /**
     * @param id {int} : l'index du produit qu'on souhaite trouver
     * @return
     */
    public String getProduit(int id) {
        try {
            String message = "Name : " + this.allProduits[id].getName() + " au prix de " + this.allProduits[id].getPrice() + " €" + "\n" + this.allProduits[id].getDescription() + "\n";
            return message;
        } catch (Exception e) {
            return "Erreur : " + e;
        }
    }

    /** Description :
     * Ajoute des produits au magasin.
     * @return {String} Produits Ajouter !!!
     */
    public String addFakeProduits(){
        Produits orange = new Produits("Orange","Les oranges bien mûre et local", 4.99F);
        Produits pomme = new Produits("pomme","Les pomme bien mûre et local", 2.99F);
        Produits fraise = new Produits("fraise","Les fraise bien mûre et local", 6.99F);
        Produits poire = new Produits("poire","Les poire bien mûre et local", 9.99F);

        addProduits(orange, 0);
        addProduits(pomme, 1);
        addProduits(fraise, 2);
        addProduits(poire, 3);
        return "Vos articles :"+orange.getName() + " "+ pomme.getName()+" "+fraise.getName()+ " "+ poire.getName()+ "ont été ajouter !!";
    }

    @Override
    public String toString() {
        return "Magazin{" +
                "name='" + this.name + '\'' +
                ", idMagazin=" + this.id_Magazin +
                ", allProduits=" + Arrays.toString(this.allProduits) +
                '}';
    }
}
