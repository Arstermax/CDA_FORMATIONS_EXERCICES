package magasin.Class.Custumer;

public class Client extends Custumer {

    private static int allClients;
    private int idClient;
    public Client(String firstname, String lastname, String genre, int age) {
        super(firstname, lastname, genre, age);
        allClients++;
        this.idClient = allClients;
    }

    public  int getIdClient(){
        return idClient;
    }
}
