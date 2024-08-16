package org.example;

 public class Main {
    public static void main(String[] args) {
        Livre HarryPotter = new Livre("Harry Potter", "JK Rollings","Jsp Rolling", "1",true);
        SecurityBookProxy book = new SecurityBookProxy();
        System.out.println(book.readBook(HarryPotter));
    }
}