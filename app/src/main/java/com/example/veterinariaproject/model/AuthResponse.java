package com.example.veterinariaproject.model;


public class AuthResponse {

    private boolean autenticacionExitosa;
    private String mensaje;
    private Long idUsuario;


    public AuthResponse() {
    }

    public AuthResponse(boolean autenticacionExitosa, String mensaje, Long idUsuario) {
        this.autenticacionExitosa = autenticacionExitosa;
        this.mensaje = mensaje;
        this.idUsuario = idUsuario;
    }

    public boolean isAutenticacionExitosa() {
        return autenticacionExitosa;
    }

    public void setAutenticacionExitosa(boolean autenticacionExitosa) {
        this.autenticacionExitosa = autenticacionExitosa;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
