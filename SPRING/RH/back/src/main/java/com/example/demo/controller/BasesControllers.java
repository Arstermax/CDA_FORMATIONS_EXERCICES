package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BasesControllers<P,G> {

    public ResponseEntity<List<G>> getAll();

    public ResponseEntity<G> getById(Long id);

    public ResponseEntity<G> add(P entity);

    public ResponseEntity<G> update(P entity, long id);
    public ResponseEntity<String>  delete(long id);
}
