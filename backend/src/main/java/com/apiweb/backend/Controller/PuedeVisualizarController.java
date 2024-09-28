package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.PuedeVisualizarModel;
import com.apiweb.backend.Service.IPuedeVisualizarService;


@RestController
@RequestMapping("/apiweb/v1/puededescargar")//endpoint

public class PuedeVisualizarController {
    @Autowired IPuedeVisualizarService puedeVisualizarService;
    @PostMapping("/insertar")

    public ResponseEntity<String> crearPuedeDescargar(@RequestBody PuedeVisualizarModel puedeVisualizar){
        return new ResponseEntity<>(puedeVisualizarService.crearPuedeVisualizar(puedeVisualizar),HttpStatus.OK);
    }
    
}
