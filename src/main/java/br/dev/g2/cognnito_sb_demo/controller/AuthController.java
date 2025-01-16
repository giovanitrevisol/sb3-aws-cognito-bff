package br.dev.g2.cognnito_sb_demo.controller;

import br.dev.g2.cognnito_sb_demo.controller.request.AuthRequest;
import br.dev.g2.cognnito_sb_demo.controller.request.AuthResponse;
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
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        var result = authService.login(authRequest.getUsername(), authRequest.getPassword(), authRequest.getClientId());
        AuthResponse authResponse = new AuthResponse(result.accessToken(), result.idToken(), result.refreshToken(), result.tokenType(), result.expiresIn());

        return ResponseEntity.ok(authResponse);
    }

}
