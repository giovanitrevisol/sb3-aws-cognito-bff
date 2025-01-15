package br.dev.g2.cognnito_sb_demo.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AuthService {

    public String getTokenFromCognito(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://sa-east-1nxp88s3dy.auth.sa-east-1.amazoncognito.com/oauth2/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.setBasicAuth("3068elrou8k4slnf80du7ihi72", ""); // Substitua SEU_CLIENT_ID pelo App Client ID
        headers.setBasicAuth("3068elrou8k4slnf80du7ihi72", "fe3cjdmgob0i5mstqmhrb8ub6ts6q9355enue6s981jb0i5ro5k");

        String body = "grant_type=password&username=" + username + "&password=" + password;

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().get("id_token").toString();
        } else {
            throw new RuntimeException("Falha ao obter o token do Cognito");
        }
    }
}
