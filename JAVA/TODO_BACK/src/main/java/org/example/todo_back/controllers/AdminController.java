package org.example.todo_back.controllers;

import org.example.todo_back.dto.responses.GetReponseBases;
import org.example.todo_back.dto.todos.TodoGetDto;
import org.example.todo_back.dto.todos.TodoPostDto;
import org.example.todo_back.models.TodoEntity;
import org.example.todo_back.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}/todos")
    public ResponseEntity<GetReponseBases> getTodo(@PathVariable long id){

        return new ResponseEntity<>(new GetReponseBases("Succèes", todoService.findAllTodoUser(id)), HttpStatus.OK);
    }

    @PostMapping("/todos/add")
    public ResponseEntity<GetReponseBases> addTodoByUser(@RequestBody TodoPostDto todoPostDto){
        return new ResponseEntity<>(new GetReponseBases("succèes",todoService.save(todoPostDto)),HttpStatus.OK);
    }

    @PostMapping("/todos/update/{idTodos}")
    private ResponseEntity<GetReponseBases> updateToEtat(@PathVariable long idTodos, @RequestBody TodoPostDto todoPostDto){
        return new ResponseEntity<>(new GetReponseBases("update",todoService.update(todoPostDto, idTodos)), HttpStatus.OK);
    }
}
