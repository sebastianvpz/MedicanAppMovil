package com.example.veterinariaproject.apirest;

import com.example.veterinariaproject.model.ServicioDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServicioClient {

    @GET("/servicios/{id}")
    Call<ServicioDTO> obtenerServicioPorId(@Path("id") Long id);

    // Otros métodos según sea necesario
}
