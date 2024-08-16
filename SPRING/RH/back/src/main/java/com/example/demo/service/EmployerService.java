package com.example.demo.service;

import com.example.demo.dto.EmployerGetDTO;
import com.example.demo.dto.EmployerPostDTO;
import com.example.demo.entity.EmployerEntity;
import com.example.demo.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerService implements BasesServices<EmployerPostDTO, EmployerGetDTO, EmployerEntity> {

    @Autowired
    EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public EmployerGetDTO save(EmployerPostDTO entity) {
        EmployerEntity employerEntity = employerRepository.save(postToEntity(entity));
        return entityToGet(employerEntity);
    }

    @Override
    public EmployerGetDTO update(EmployerPostDTO entity, long id) {
        EmployerEntity employerEntity = employerRepository.getReferenceById(id);

        if (employerEntity != null) {
           employerRepository.save(updateEntity(entity, employerEntity));
        }
        return entityToGet(employerRepository.getReferenceById(id));
    }

    @Override
    public void delete(long id) {
        employerRepository.delete(employerRepository.getReferenceById(id));
    }

    @Override
    public EmployerGetDTO findById(long id) {
        return entityToGet(employerRepository.getReferenceById(id));
    }

    @Override
    public List<EmployerGetDTO> findAll() {
        List<EmployerEntity> employerEntities = employerRepository.findAll();
        List<EmployerGetDTO> employerGetDTOS = new ArrayList<>();
        for (EmployerEntity entity : employerEntities) {
            employerGetDTOS.add(entityToGet(entity));
        }
        return employerGetDTOS;
    }

    @Override
    public EmployerEntity postToEntity(EmployerPostDTO entity) {
        System.out.println(entity);
        EmployerEntity employerEntity = new EmployerEntity();
        employerEntity.setName(entity.getName());
        employerEntity.setIdentificationNumber(entity.getIdentificationNumber());
        employerEntity.setAddress(entity.getAddress());
        employerEntity.setPhone(entity.getPhone());
        employerEntity.setEmail(entity.getEmail());
        employerEntity.setBirthDate(entity.getBirthDate());
        employerEntity.setContractStart(entity.getContractStart());
        employerEntity.setContractEnd(entity.getContractEnd());
        employerEntity.setPassword(entity.getPassword());
        employerEntity.setRole(entity.isRole());
        employerEntity.setSalary(entity.getSalary());
        employerEntity.setObservation(entity.getObservation());
        employerEntity.setOccupation(entity.getOccupation());
        return employerEntity;
    }

    public EmployerEntity updateEntity(EmployerPostDTO newEntity, EmployerEntity entity){
        entity.setName(newEntity.getName());
        entity.setIdentificationNumber(newEntity.getIdentificationNumber());
        entity.setAddress(newEntity.getAddress());
        entity.setPhone(newEntity.getPhone());
        entity.setEmail(newEntity.getEmail());
        entity.setBirthDate(newEntity.getBirthDate());
        entity.setContractStart(newEntity.getContractStart());
        entity.setContractEnd(newEntity.getContractEnd());
        entity.setPassword(newEntity.getPassword());
        entity.setRole(newEntity.isRole());
        entity.setSalary(newEntity.getSalary());
        entity.setObservation(newEntity.getObservation());
        entity.setOccupation(newEntity.getOccupation());
        return entity;
    }

    @Override
    public EmployerGetDTO entityToGet(EmployerEntity entity) {
        EmployerGetDTO employerGetDTO = new EmployerGetDTO();
        employerGetDTO.setName(entity.getName());
        employerGetDTO.setIdentificationNumber(entity.getIdentificationNumber());
        employerGetDTO.setAddress(entity.getAddress());
        employerGetDTO.setPhone(entity.getPhone());
        employerGetDTO.setEmail(entity.getEmail());
        employerGetDTO.setBirthDate(entity.getBirthDate());
        employerGetDTO.setContractStart(entity.getContractStart());
        employerGetDTO.setContractEnd(entity.getContractEnd());
        employerGetDTO.setSalary(entity.getSalary());
        employerGetDTO.setObservation(entity.getObservation());
        employerGetDTO.setOccupation(entity.getOccupation());

        return employerGetDTO;
    }
}
