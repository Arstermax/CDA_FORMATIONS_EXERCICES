package com.example.demo.controller;

import com.example.demo.dto.EmployerGetDTO;
import com.example.demo.dto.EmployerPostDTO;
import com.example.demo.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/Employer")
public class EmployerController implements BasesControllers<EmployerPostDTO, EmployerGetDTO> {

    @Autowired
    private EmployerService employerService;

    @Override
    @GetMapping("/")
    public ResponseEntity<List<EmployerGetDTO>> getAll() {
        return  new ResponseEntity<>(employerService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EmployerGetDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(employerService.findById(id), HttpStatus.OK);
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<EmployerGetDTO> add(@RequestBody EmployerPostDTO entity) {
        return new ResponseEntity<>(employerService.save(entity), HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<EmployerGetDTO> update(@RequestBody EmployerPostDTO entity, @PathVariable long id) {
        return new ResponseEntity<>(employerService.update(entity, id), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        String message = "";
        if (employerService.findById(id) != null){
            employerService.delete(id);
            message = "Le numéro n°'" + id + "A été supprimer";
        }else{
            message = "Introuvable";
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
