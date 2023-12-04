package com.example.veterinariaproject.apirest;

import com.example.veterinariaproject.model.AuthResponse;
import com.example.veterinariaproject.model.LoginRequestDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthClient {

    @POST("/auth/login")
    Call<AuthResponse> login(@Body LoginRequestDTO loginRequestDTO);
}
