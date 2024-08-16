package org.example;

public class NewPayementProcessor {
    public boolean authenticate(String apiKey) {
        if (apiKey.equals("1234")) {
            return true;
        }else {
            return false;
        }
    }

    public String sendPayement(double amount) {
        return "Votre montant est de "+ amount + " €";
    }
}