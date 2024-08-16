package magasin;

import magasin.Class.Magasin.Magazin;
import magasin.Class.Custumer.Custumer;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       Magazin Magazin1 = new Magazin("Auchan");

        System.out.println(Magazin1.addFakeProduits());

        Custumer Alexandre = new Custumer("Alexandre","¨Penet", "M", 23);

        System.out.println(Alexandre);
        System.out.println(Alexandre.updateProfils("", "", "F", 10));
        System.out.println(Alexandre);
    }

}