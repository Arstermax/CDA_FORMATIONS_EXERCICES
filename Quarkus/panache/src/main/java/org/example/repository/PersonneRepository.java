package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.Personne;

import java.util.List;

@ApplicationScoped
public class PersonneRepository implements PanacheRepository<Personne> {

    public List<Personne> findByFirstname(String firstname) {
        return find("firstname", firstname).list();
    }

    public List<Personne> findByFirstnameAndLastname(String firstname, String lastname){
        return find("firstname = ?1 and lastname = ?2",firstname, lastname).list();
    }

     
}
