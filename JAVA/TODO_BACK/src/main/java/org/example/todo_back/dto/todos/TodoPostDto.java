package org.example.todo_back.dto.todos;

import jakarta.persistence.Column;
import lombok.Data;
import org.example.todo_back.dto.users.UserPostDto;
import org.example.todo_back.models.UserEntity;
import org.example.todo_back.utils.EtatTodos;

@Data
public class TodoPostDto {
    private String name;
    private String description;
    private long idUsers;
    private EtatTodos etatTodos;
}
