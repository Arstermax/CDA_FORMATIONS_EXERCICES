package org.example.todo_back.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.example.todo_back.utils.EtatTodos;

import java.time.LocalDate;

@Entity
@Data
@ToString(exclude = {"users"})
@Table(name = "todos")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private long id;

    @Column(name = "todo_name")
    private String name;

    @Column(name = "todo_description")
    private String description;

    @Column(name="todo_etat")
    private EtatTodos etat = EtatTodos.PasCommencer;


    @ManyToOne
    @JoinColumn(name = "users")
    @JsonBackReference
    private UserEntity users;
}

