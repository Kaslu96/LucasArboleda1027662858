package com.prueba.spring_boot_microservice_1_inmueble.dto;

public class ResponseDTO {

    private String mensaje;

    public ResponseDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
