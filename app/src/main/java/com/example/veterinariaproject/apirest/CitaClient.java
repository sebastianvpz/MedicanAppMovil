package com.example.veterinariaproject.apirest;

import com.example.veterinariaproject.model.CitaDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CitaClient {

    @GET("/citas/{id}")
    Call<CitaDTO> obtenerCitaPorId(@Path("id") Long id);

    @POST("/citas/crear")
    Call<CitaDTO> crearCita(@Body CitaDTO citaDTO);
}
