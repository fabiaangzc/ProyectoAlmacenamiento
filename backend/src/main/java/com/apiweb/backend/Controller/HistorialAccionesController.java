package com.apiweb.backend.Controller;

import com.apiweb.backend.Model.HistorialAccionesModel;
import com.apiweb.backend.Service.IHistorialAccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiweb/v1/historialacciones")
public class HistorialAccionesController {

    @Autowired
    private IHistorialAccionesService historialAccionesService;

    public HistorialAccionesController() {
    }

    @GetMapping("/acciones")
    public ResponseEntity<List<HistorialAccionesModel>> obtenerHistorial() {
        List<HistorialAccionesModel> historial = historialAccionesService.obtenerHistorialAcciones();
        return ResponseEntity.ok(historial);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<HistorialAccionesModel> crearHistorial(@RequestBody HistorialAccionesModel historial) {
        HistorialAccionesModel nuevoHistorial = historialAccionesService.guardarHistorial(historial);
        return new ResponseEntity<>(nuevoHistorial, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerHistorialPorId(@PathVariable int id) {
        try {
            HistorialAccionesModel historial = historialAccionesService.buscarHistorialPorId(id);
            return ResponseEntity.ok(historial);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarHistorial(@PathVariable int id) {
        try {
            return new ResponseEntity<>(historialAccionesService.eliminarHistorial(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

