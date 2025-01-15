package br.dev.g2.cognnito_sb_demo.controller.request;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;
    private String password;
}
