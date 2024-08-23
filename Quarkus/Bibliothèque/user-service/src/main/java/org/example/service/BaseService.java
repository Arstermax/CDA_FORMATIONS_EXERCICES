package org.example.service;

public interface BaseService <E,D>{

    public E dtoToEntity(D dto);

    public D entityToDto(E entity);

    public E oldEntityToNewEntity(E oldEntity, E newEntity);
}
