package com.apiweb.backend.Controller;

import com.apiweb.backend.Model.ValoracionModel;
import com.apiweb.backend.Service.IValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiweb/v1/valoraciones")
public class ValoracionController {

    @Autowired
    private IValoracionService valoracionService;

    // Crear una nueva valoración
    @PostMapping("/crear")
    public ResponseEntity<String> crearValoracion(@RequestBody ValoracionModel valoracion) {
        valoracionService.guardarValoracion(valoracion);
        return new ResponseEntity<>("Valoración creada correctamente", HttpStatus.CREATED);
    }

    // Obtener todas las valoraciones
    @GetMapping("/todas")
    public ResponseEntity<List<ValoracionModel>> obtenerTodasLasValoraciones() {
        List<ValoracionModel> valoraciones = valoracionService.obtenerTodasLasValoraciones();
        return new ResponseEntity<>(valoraciones, HttpStatus.OK);
    
    }
}
