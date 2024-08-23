package org.example.service;

import java.util.List;


public interface ReviewService<E,D> extends BaseService<E,D>{
    public D save(D entity);
    public D saveEntity(E entity);

    public D update(long id, D entity);
    public boolean delete(long id);
    public List<D> findAll();
    public D findByID(long id);

}
