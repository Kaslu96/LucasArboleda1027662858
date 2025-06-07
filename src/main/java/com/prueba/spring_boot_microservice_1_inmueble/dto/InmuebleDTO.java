package com.prueba.spring_boot_microservice_1_inmueble.dto;

import java.time.LocalDateTime;

public class InmuebleDTO {

    private Long id;
    private String nombre;
    private String direccion;
    private String picture;
    private Double precio;
    private LocalDateTime fechaCreacion;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

}