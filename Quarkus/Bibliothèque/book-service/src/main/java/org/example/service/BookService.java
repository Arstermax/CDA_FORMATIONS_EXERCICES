package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.repository.BookRepository;

import java.util.List;


public interface BookService<E,D> extends BaseService<E,D>{
    public D save(D entity);
    public D saveEntity(E entity);

    public D update(long id, D entity);
    public boolean delete(long id);
    public List<D> findAll();
    public D findByID(long id);

}
