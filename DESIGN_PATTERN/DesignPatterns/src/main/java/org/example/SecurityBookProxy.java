package org.example;

public class SecurityBookProxy implements Book{
    RealBook realBook = new RealBook();
    @Override
    public String readBook(Livre livre) {
        if (livre.isAbonnement()){
            return realBook.readBook(livre);
        }else{
            throw new RuntimeException("Votre aboonement à été expirer!!!");
        }
    }
}
