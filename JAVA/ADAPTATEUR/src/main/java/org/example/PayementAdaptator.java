package org.example;

import java.util.Scanner;

public class PayementAdaptator implements OldPayementCategories {

    private NewPayementProcessor newPayement = new NewPayementProcessor();
    Scanner scanner = new Scanner(System.in);

    @Override
    public String makePayement(String accountNumber, double amount)  {
        return newPayement.sendPayement(amount);
    }

    public boolean login(String password){
        if(newPayement.authenticate(password)){
            return true;
        }else{
            return false;
        }
    }


}
