package com.example.veterinariaproject.model;

public class ServicioDTO {

    private Long idServicio;
    private String nombre;
    private String descripcion;
    private String horario;
    private double costo;


    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
