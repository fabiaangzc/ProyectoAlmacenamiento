package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.PuedeDescargarModel;
import com.apiweb.backend.Service.IPuedeDescargarService;

@RestController
@RequestMapping("/apiweb/v1/puededescargar")//endpoint
public class PuedeDescargarController {
    @Autowired IPuedeDescargarService puedeDescargarService;
    @PostMapping("/insertar")

    public ResponseEntity<String> crearPuedeDescargar(@RequestBody PuedeDescargarModel puedeDescargar){
        return new ResponseEntity<>(puedeDescargarService.crearPuedeDescargar(puedeDescargar),HttpStatus.OK);
    }
    
}
