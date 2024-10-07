package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Exeption.RecursoNoEncontradoException;
import com.apiweb.backend.Model.ValoracionModel;
import com.apiweb.backend.Service.IValoracionService;

@RestController
@RequestMapping("/apiweb/v1/valoraciones")
public class ValoracionController {

    @Autowired
    IValoracionService valoracionService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearValoracion(@RequestBody ValoracionModel valoracion) {
        try {
            return new ResponseEntity<>(valoracionService.guardarValoracion(valoracion), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarValoracionPorId(@PathVariable int id) {
        try {
            ValoracionModel valoracion = valoracionService.buscarValoracionPorId(id);
            return ResponseEntity.ok(valoracion);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarValoracion(@PathVariable int id, @RequestBody ValoracionModel valoracion) {
        try {
            return new ResponseEntity<>(valoracionService.editarValoracion(id, valoracion), HttpStatus.OK);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarValoracion(@PathVariable int id) {
        try {
            return new ResponseEntity<>(valoracionService.eliminarValoracion(id), HttpStatus.OK);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar la valoración: " + e.getMessage());
        }
    }
}
