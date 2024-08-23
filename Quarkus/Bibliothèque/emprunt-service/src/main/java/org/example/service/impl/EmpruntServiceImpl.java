package org.example.service.impl;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.dto.EmpruntDto;
import org.example.entity.Emprunt;
import org.example.repository.EmpruntRepository;
import org.example.service.EmpruntService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmpruntServiceImpl implements EmpruntService<Emprunt, EmpruntDto> {

    @Inject
    EmpruntRepository userRepository;

    @Override
    public Emprunt dtoToEntity(EmpruntDto dto) {
        Emprunt emprunt = new Emprunt();
        emprunt.setId(dto.getId());
        emprunt.setLibelle(dto.getLibelle());
        emprunt.setMontant(dto.getMontant());
        emprunt.setEmpruntNumber(emprunt.getEmpruntNumber());
        return emprunt;
    }

    @Override
    public EmpruntDto entityToDto(Emprunt entity) {
        return new EmpruntDto(entity.getId(),entity.getLibelle(),entity.getEmpruntNumber(), entity.getMontant());
    }

    @Override
    public Emprunt oldEntityToNewEntity(Emprunt oldEntity, Emprunt newEntity) {
        oldEntity.setId(newEntity.getId());
        oldEntity.setLibelle(newEntity.getLibelle());
        oldEntity.setMontant(newEntity.getMontant());
        oldEntity.setEmpruntNumber(newEntity.getEmpruntNumber());
        return oldEntity;
    }

    @Override
    public EmpruntDto save(EmpruntDto entity) {
        userRepository.persist(dtoToEntity(entity));
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public EmpruntDto saveEntity(Emprunt entity) {
        userRepository.persist(entity);
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public EmpruntDto update(long id, EmpruntDto entity) {
        Emprunt oldEmprunt = dtoToEntity(findByID(id));
        if (oldEmprunt == null)
            return null;
        Emprunt emprunt = oldEntityToNewEntity(oldEmprunt, dtoToEntity(entity));
        return save(entityToDto(emprunt));
    }

    @Override
    public boolean delete(long id) {
        if (findByID(id) == null)
            return false;
        return userRepository.deleteById(id);
    }

    @Override
    public List<EmpruntDto> findAll() {
        PanacheQuery<Emprunt> emprunts = userRepository.findAll();
        List<EmpruntDto> empruntDtos = new ArrayList<>();
        for (Emprunt emprunt : emprunts.list()) {
            empruntDtos.add(entityToDto(emprunt));
        }
        return empruntDtos;
    }

    @Override
    public EmpruntDto findByID(long id) {
        return entityToDto(userRepository.findById(id));
    }
}
