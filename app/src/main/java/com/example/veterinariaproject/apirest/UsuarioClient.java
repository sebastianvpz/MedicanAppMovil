package com.example.veterinariaproject.apirest;

import com.example.veterinariaproject.model.UsuarioDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface UsuarioClient {

    @GET("/usuarios/{id}")
    Call<UsuarioDTO> obtenerUsuarioPorId(@Path("id") Long id);

    @POST("/usuarios")
    Call<UsuarioDTO> crearUsuario(@Body UsuarioDTO usuarioDTO);

    @PUT("/usuarios/{id}")
    Call<UsuarioDTO> actualizarUsuario(@Path("id") Long id, @Body UsuarioDTO usuarioDTO);
}
