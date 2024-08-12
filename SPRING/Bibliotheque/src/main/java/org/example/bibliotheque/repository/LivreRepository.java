package org.example.bibliotheque.repository;

import org.example.bibliotheque.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {
}
