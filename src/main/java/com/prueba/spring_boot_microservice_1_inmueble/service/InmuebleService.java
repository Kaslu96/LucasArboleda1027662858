package com.prueba.spring_boot_microservice_1_inmueble.service;

import com.prueba.spring_boot_microservice_1_inmueble.dto.InmuebleDTO;
import com.prueba.spring_boot_microservice_1_inmueble.model.Inmueble;

import java.util.List;

public interface InmuebleService {

    InmuebleDTO saveInmueble(InmuebleDTO inmueble);

    void deleteInmueble(Long inmuebleId);

    List<InmuebleDTO> findAllInmuebles();

    InmuebleDTO findInmuebles(Long id);
}
