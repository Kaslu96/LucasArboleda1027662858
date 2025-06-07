package com.prueba.spring_boot_microservice_1_inmueble.service.impl;

import com.prueba.spring_boot_microservice_1_inmueble.dto.InmuebleDTO;
import com.prueba.spring_boot_microservice_1_inmueble.model.Inmueble;
import com.prueba.spring_boot_microservice_1_inmueble.repository.InmuebleRepository;
import com.prueba.spring_boot_microservice_1_inmueble.service.InmuebleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InmuebleServiceImpl implements InmuebleService {

    private final InmuebleRepository inmuebleRepository;

    public InmuebleServiceImpl(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    @Override
    public InmuebleDTO saveInmueble(InmuebleDTO dto) {
        Inmueble inmueble = convertirAEntidad(dto);
        inmueble.setFechaCreacion(LocalDateTime.now());
        Inmueble inmuebleGuardado = inmuebleRepository.save(inmueble);
        return convertirADTO(inmuebleGuardado);
    }

    @Override
    public void deleteInmueble(Long inmuebleId) {
        inmuebleRepository.deleteById(inmuebleId);
    }

    @Override
    public List<InmuebleDTO> findAllInmuebles() {
        return inmuebleRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public InmuebleDTO findInmuebles(Long id){
        Optional<Inmueble> inmuebleEcnontrado = inmuebleRepository.findById(id);
        if (inmuebleEcnontrado.isPresent()) {
            return convertirADTO(inmuebleEcnontrado.get());
        } else {
            return null;
        }
    }

    private InmuebleDTO convertirADTO(Inmueble entidad) {
        InmuebleDTO dto = new InmuebleDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setDireccion(entidad.getDireccion());
        dto.setPicture(entidad.getPicture());
        dto.setPrecio(entidad.getPrecio());
        dto.setFechaCreacion(entidad.getFechaCreacion());
        return dto;
    }

    private Inmueble convertirAEntidad(InmuebleDTO dto) {
        Inmueble entidad = new Inmueble();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setDireccion(dto.getDireccion());
        entidad.setPicture(dto.getPicture());
        entidad.setPrecio(dto.getPrecio());
        entidad.setFechaCreacion(dto.getFechaCreacion());
        return entidad;
    }
}
