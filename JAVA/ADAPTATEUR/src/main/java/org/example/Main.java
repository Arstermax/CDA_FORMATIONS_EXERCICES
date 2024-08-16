package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        PayementAdaptator payement = new PayementAdaptator();
        Scanner scanner = new Scanner(System.in);

        String password;

        System.out.println("Votre mot de passe");
        password = scanner.next();

        if (payement.login(password)) {
            System.out.println(payement.makePayement("1", 1234.39));
        }else{
            System.out.println("Votre mot de passe est incorrect");
        }

    }
}