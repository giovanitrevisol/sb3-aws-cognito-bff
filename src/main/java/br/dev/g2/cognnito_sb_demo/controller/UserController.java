package br.dev.g2.cognnito_sb_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping
    public ResponseEntity<String> userInfo(){
        return ResponseEntity.ok("You access a protect endpoint");
    }
}
