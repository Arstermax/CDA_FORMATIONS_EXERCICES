package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Personne {

    @Id
    @GeneratedValue
    private long idPersonne;
    private String firstname;
    private String lastname;
    private int age;
}
