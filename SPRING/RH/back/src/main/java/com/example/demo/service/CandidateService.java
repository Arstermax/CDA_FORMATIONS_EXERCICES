package com.example.demo.service;

import com.example.demo.dto.CandidateGetDTO;
import com.example.demo.dto.CandidatePostDTO;
import com.example.demo.entity.CandidateEntity;
import com.example.demo.repository.EmployerRepository;

import java.util.List;

public class CandidateService implements BasesServices<CandidatePostDTO, CandidateGetDTO, CandidateEntity>{

    EmployerRepository employerRepository;

    public CandidateService(EmployerRepository employerRepository){this.employerRepository = employerRepository;}


    @Override
    public CandidateGetDTO save(CandidatePostDTO entity) {
        return null;
    }

    @Override
    public CandidateGetDTO update(CandidatePostDTO entity, long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public CandidateGetDTO findById(long id) {
        return null;
    }

    @Override
    public List<CandidateGetDTO> findAll() {
        return null;
    }

    @Override
    public CandidateEntity postToEntity(CandidatePostDTO entity) {
        return null;
    }

    @Override
    public CandidateGetDTO entityToGet(CandidateEntity entity) {
        return null;
    }
}
