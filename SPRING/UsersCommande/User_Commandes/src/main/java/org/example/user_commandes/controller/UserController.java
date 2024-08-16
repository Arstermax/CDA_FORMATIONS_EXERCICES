package org.example.user_commandes.controller;

import org.example.user_commandes.dto.UserDto;
import org.example.user_commandes.service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/add")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        System.out.println(userDto.getName());
        return ResponseEntity.ok(userServiceImp.save(userDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable long id){
        return ResponseEntity.ok(userServiceImp.findUserById(id));
    }
}
