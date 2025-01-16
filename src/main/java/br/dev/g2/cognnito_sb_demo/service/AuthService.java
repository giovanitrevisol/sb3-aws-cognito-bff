package br.dev.g2.cognnito_sb_demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthFlowType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthenticationResultType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthResponse;

import java.util.Map;

@Service
public class AuthService {

    private final CognitoIdentityProviderClient cognitoClient;

    @Value("${aws.clientSecret}")
    private String clientSecret;


    public AuthService(CognitoIdentityProviderClient cognitoClient) {
        this.cognitoClient = cognitoClient;
    }

    public AuthenticationResultType login(String username, String password, String clientId) {

        String secretHash = CognitoSecretHash.calculateSecretHash(clientId, clientSecret, username);

        InitiateAuthRequest authRequest = InitiateAuthRequest.builder()
                .authFlow(AuthFlowType.USER_PASSWORD_AUTH)
                .clientId(clientId)
                .authParameters(Map.of(
                        "USERNAME", username,
                        "PASSWORD", password,
                        "SECRET_HASH", secretHash
                ))
                .build();

        InitiateAuthResponse response = cognitoClient.initiateAuth(authRequest);
        return response.authenticationResult();
    }
}
