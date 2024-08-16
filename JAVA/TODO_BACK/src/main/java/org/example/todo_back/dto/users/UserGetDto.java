package org.example.todo_back.dto.users;

import lombok.Data;

@Data
public class UserGetDto {
    private long id;
    private String name;
    private String email;
    private String roles;
}
