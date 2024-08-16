package org.example.todo_back.dto.todos;

import lombok.Data;
import org.example.todo_back.utils.EtatTodos;

@Data
public class TodoGetDto {
    private long id;
    private String name;
    private String description;
    private EtatTodos etat;
}
