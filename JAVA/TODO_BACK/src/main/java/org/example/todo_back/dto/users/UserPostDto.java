package org.example.todo_back.dto.users;

import jakarta.persistence.Column;
import lombok.Data;
import org.example.todo_back.utils.EtatRoles;

@Data
public class UserPostDto {
    private String name;
    private String email;
    private String password;
    private String roles;
}
