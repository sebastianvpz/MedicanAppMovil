package com.example.veterinariaproject.apirest;

import com.example.veterinariaproject.model.MedicoDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MedicoClient {

    @GET("/medicos/{id}")
    Call<MedicoDTO> obtenerMedicoPorId(@Path("id") Long id);


}
