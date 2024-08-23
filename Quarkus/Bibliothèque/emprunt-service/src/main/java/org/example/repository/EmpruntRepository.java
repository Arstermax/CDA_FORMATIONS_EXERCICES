package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.Emprunt;

@ApplicationScoped
public class EmpruntRepository implements PanacheRepository<Emprunt> {
}
