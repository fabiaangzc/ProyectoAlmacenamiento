package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.ValoracionModel;
import com.apiweb.backend.Service.IValoracionService;

@RestController
@RequestMapping("/apiweb/v1/valoraciones")
public class ValoracionController {

    @Autowired
    IValoracionService valoracionService;

    @PostMapping("/insertar")
    public ResponseEntity<String> crearValoracion(@RequestBody ValoracionModel valoracion){
        return new ResponseEntity<String>(valoracionService.guardarValoracion(valoracion), HttpStatus.OK);
    }
    
}
