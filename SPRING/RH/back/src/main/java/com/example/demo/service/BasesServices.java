package com.example.demo.service;

import java.util.List;

public interface BasesServices<P,G,E> {
 public G save(P entity);

 public G update(P entity, long id);
 public void delete(long id);

 public G findById(long id);
 public List<G> findAll();
 public E postToEntity(P entity);
 public G entityToGet(E entity);
}
