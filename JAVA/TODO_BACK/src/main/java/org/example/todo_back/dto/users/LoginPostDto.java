package org.example.todo_back.dto.users;

import lombok.Data;

@Data
public class LoginPostDto {
    private String email;
    private String password;
}
