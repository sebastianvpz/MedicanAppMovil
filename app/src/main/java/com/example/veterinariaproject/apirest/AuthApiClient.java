package com.example.veterinariaproject.apirest;

import com.example.veterinariaproject.model.AuthResponse;
import com.example.veterinariaproject.model.LoginRequestDTO;

import retrofit2.Call;

public class AuthApiClient {

    private final AuthClient authClient;

    public AuthApiClient(AuthClient authClient) {
        this.authClient = authClient;
    }

    public Call<AuthResponse> login(LoginRequestDTO loginRequestDTO) {
        return authClient.login(loginRequestDTO);
    }
}
