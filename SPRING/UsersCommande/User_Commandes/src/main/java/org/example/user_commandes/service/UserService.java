package org.example.user_commandes.service;

public interface UserService <E, D> {
    public D save(D entite);

    public D findUserById(long id);

    public E transformDtoatEntity(D entite);

    public D transformEntityAtDTO(E enity);
}
