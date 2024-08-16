package org.example.todo_back.services;

import java.util.List;
import java.util.Optional;

public interface BasesServices <G, P, E>{

    public G findBYId(long id);
    public List<G> findAll();

    public G save(P entity);

    public G update(P entity, long id);

    public String  deleteById(long id);

    public G entityToGet (E entity);
    public E postToEntity(P entity);
}
