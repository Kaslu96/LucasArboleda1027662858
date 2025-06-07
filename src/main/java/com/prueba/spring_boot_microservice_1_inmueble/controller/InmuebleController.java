package com.prueba.spring_boot_microservice_1_inmueble.controller;

import com.prueba.spring_boot_microservice_1_inmueble.dto.InmuebleDTO;
import com.prueba.spring_boot_microservice_1_inmueble.dto.ResponseDTO;
import com.prueba.spring_boot_microservice_1_inmueble.model.Inmueble;
import com.prueba.spring_boot_microservice_1_inmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inmueble")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    @PostMapping
    public ResponseEntity<InmuebleDTO> saveInmueble(@RequestBody InmuebleDTO inmueble) {
        return new ResponseEntity<>(inmuebleService.saveInmueble(inmueble), HttpStatus.CREATED);
    }

    @DeleteMapping("{inmuebleId}")
    public ResponseEntity<ResponseDTO> deleteInmueble(@PathVariable Long inmuebleId) {
        inmuebleService.deleteInmueble(inmuebleId);
        return new ResponseEntity<>(new ResponseDTO("Eliminado Correctamente"),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InmuebleDTO>> getAllInmuebles() {
        return ResponseEntity.ok(inmuebleService.findAllInmuebles());
    }

    @GetMapping("{inmuebleId}")
    public ResponseEntity<InmuebleDTO> getInmuble(@PathVariable Long inmuebleId) {
        return ResponseEntity.ok(inmuebleService.findInmuebles(inmuebleId));
    }
}
