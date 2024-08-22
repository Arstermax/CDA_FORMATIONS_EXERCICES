package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.Client;

import java.util.Optional;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> { }
