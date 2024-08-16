package org.example.gestionauto.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class methodController {

    @GetMapping("/")
    public void getMethod(){
        System.out.println("GET");
    }

    @PostMapping("/")
    public void  postMethod(){
        System.out.println("POST");
    }

    @PutMapping("/")
    public void putMethod(){
        System.out.println("PUT");
    }

    @DeleteMapping("/")
    public void deleteMethod(){
        System.out.println("DELETE");
    }
}
