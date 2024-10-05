package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.PuedeEscribirModel;
import com.apiweb.backend.Service.IPuedeEscribirService;


@RestController
@RequestMapping("/apiweb/v1/puedeescribir")//endpoint

public class PuedeEscribirController {
    @Autowired IPuedeEscribirService puedeEscribirService;
    @PostMapping("/insertar")

    public ResponseEntity<String> crearPuedeEscribir(@RequestBody PuedeEscribirModel puedeEscribir){
        return new ResponseEntity<>(puedeEscribirService.crearPuedeEscribir(puedeEscribir),HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPuedeEscribir(@PathVariable("id") Integer idEscribir){
        return new ResponseEntity<>(puedeEscribirService.eliminarPuedeEscribir(idEscribir),HttpStatus.OK);
    }
}
