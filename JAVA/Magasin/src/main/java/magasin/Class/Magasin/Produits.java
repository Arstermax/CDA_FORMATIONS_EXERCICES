package magasin.Class.Magasin;

public class Produits {

    private static int idProduits;
    private String name;
    private String description;
    private float price;

    public  Produits(String name, String description, Float price){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}
