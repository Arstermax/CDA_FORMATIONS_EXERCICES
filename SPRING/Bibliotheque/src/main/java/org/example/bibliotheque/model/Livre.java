package org.example.bibliotheque.model;

import jakarta.persistence.*;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "livre_name")
    private String name;

    @Column(name = "livre_price")
    private long price;
}
