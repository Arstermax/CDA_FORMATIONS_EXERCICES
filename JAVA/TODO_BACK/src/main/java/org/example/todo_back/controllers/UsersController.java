package org.example.todo_back.controllers;

import org.example.todo_back.dto.responses.GetReponseBases;
import org.example.todo_back.dto.users.LoginPostDto;
import org.example.todo_back.dto.users.UserGetDto;
import org.example.todo_back.dto.users.UserPostDto;
import org.example.todo_back.services.TodoService;
import org.example.todo_back.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private TodoService todoService;
    @Autowired
    private UserService userService;
    private String message = "";
    private Object data;
    private HttpStatus status;

    @GetMapping("/todos")
    private ResponseEntity<GetReponseBases> findAllTodos() {
        try {
            if (todoService.findAll() != null) {
                message = "Succes";
                data = todoService.findAll();
                status = HttpStatus.OK;
            }
            return new ResponseEntity<>(new GetReponseBases(message, data), status);
        } catch (Exception e) {
            message = e.getMessage();
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(new GetReponseBases(message), status);
        }
    }

    @GetMapping("/todos/{id}")
    private ResponseEntity<GetReponseBases> findByIdTodo(@PathVariable long id) {
        try {
            if (todoService.findBYId(id) != null) {
                message = "Succes";
                data = todoService.findBYId(id);
                status = HttpStatus.OK;
            }
            return new ResponseEntity<>(new GetReponseBases(message, data), status);
        } catch (Exception e) {
            message = e.getMessage();
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(new GetReponseBases(message), status);
        }
    }

    @PostMapping("/add")
    private ResponseEntity<GetReponseBases> AddUsers(@RequestBody UserPostDto userPostDto) {
        try {
            UserGetDto userGetDto = userService.save(userPostDto);
            if (userGetDto != null) {
                message = "L'utilisateur " + userGetDto.getName() + " à été créer ";
                data = userGetDto;
            }
            return new ResponseEntity<>(new GetReponseBases(message, userPostDto), HttpStatus.CREATED);
        } catch (Exception e) {
            message = e.getMessage();
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(new GetReponseBases(message), status);
        }

    }

    @PostMapping("/login")
    private ResponseEntity<GetReponseBases> Login(@RequestBody LoginPostDto loginPostDto) {
        try {
            Map<String, Object> data = new HashMap<>();

            if (userService.checUserNameExists(loginPostDto.getEmail())) {
                if (userService.verifyUser(loginPostDto.getEmail(), loginPostDto.getPassword())) {
                    data.put("token", userService.generateToken(loginPostDto.getEmail(), loginPostDto.getPassword()));
                    System.out.println(data);
                    status = HttpStatus.ACCEPTED;

                }else{
                    message = "Password inexistant";
                    status = HttpStatus.BAD_REQUEST;
                }
            } else {
                message = "Email inexistant";
                status = HttpStatus.BAD_REQUEST;
            }
            return new ResponseEntity<>(new GetReponseBases(message, data), status);

        } catch (Exception e) {
            message = e.getMessage();
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(new GetReponseBases(message), status);
        }

    }
}
