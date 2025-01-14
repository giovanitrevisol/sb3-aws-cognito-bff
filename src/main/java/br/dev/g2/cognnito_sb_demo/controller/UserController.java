package br.dev.g2.cognnito_sb_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

    @GetMapping()
    public String getUser() {
        return "Access granted: Read user details";
    }
}
