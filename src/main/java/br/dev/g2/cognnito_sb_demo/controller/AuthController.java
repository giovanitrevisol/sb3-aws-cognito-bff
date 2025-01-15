package br.dev.g2.cognnito_sb_demo.controller;

import br.dev.g2.cognnito_sb_demo.controller.request.AuthRequest;
import br.dev.g2.cognnito_sb_demo.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        String token = authService.getTokenFromCognito(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok(token);
    }

}
