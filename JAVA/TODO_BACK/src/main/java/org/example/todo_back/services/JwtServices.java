package org.example.todo_back.services;

public interface JwtServices {

    public boolean verifyUser(String email, String password);
    public boolean checUserNameExists(String email);

    public String generateToken(String email, String password);

}
