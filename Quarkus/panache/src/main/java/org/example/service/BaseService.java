package org.example.service;

import java.util.List;
import java.util.Optional;

public interface BaseService <G,E,P> {

    public G entityToGetDTO(E entity);
    public E postToEntity(P postEntity);

    public G save(E entity);

    public G update (long id, P entity);
    public void delete(long id);

    public Optional<E> findById(long id);
    public List<Optional<E>> findAll();
}
