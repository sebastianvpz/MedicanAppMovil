package com.example.veterinariaproject.apirest;

import com.example.veterinariaproject.model.MascotaDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MascotaClient {

    @GET("/mascotas/{id}")
    Call<MascotaDTO> obtenerMascotaPorId(@Path("id") Long id);

    @POST("/mascotas")
    Call<MascotaDTO> crearMascota(@Body MascotaDTO mascotaDTO);

    @GET("/mascotas/usuario/{idUsuario}")
    Call<List<MascotaDTO>> obtenerMascotasPorIdUsuario(@Path("idUsuario") Long idUsuario);
}
