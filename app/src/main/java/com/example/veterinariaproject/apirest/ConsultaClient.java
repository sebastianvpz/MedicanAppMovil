package com.example.veterinariaproject.apirest;

import com.example.veterinariaproject.model.ConsultaDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConsultaClient {

    @GET("/consultas/{id}")
    Call<ConsultaDTO> obtenerConsultaPorId(@Path("id") Long id);

    @GET("/consultas/mascota/{idMascota}")
    Call<List<ConsultaDTO>> obtenerConsultasPorIdMascota(@Path("idMascota") Long idMascota);
}
