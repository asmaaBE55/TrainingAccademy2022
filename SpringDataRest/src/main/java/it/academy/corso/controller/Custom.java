package it.academy.corso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mionome")
public class Custom {
    @GetMapping("/nome")
    public ResponseEntity<String> nome (){
        String message = "Asmaa ";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
