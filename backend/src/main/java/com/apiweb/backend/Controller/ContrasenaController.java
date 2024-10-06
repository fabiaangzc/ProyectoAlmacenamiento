package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.ContrasenaModel;
import com.apiweb.backend.Service.IContrasenaService;

@RestController
@RequestMapping("/apieweb/v1/contrasenas")
public class ContrasenaController {
    @Autowired
    IContrasenaService contrasenaService;
    
    @PostMapping("/insertar")
    public ResponseEntity<String> crearContrasena(@RequestBody ContrasenaModel contrasena) {
        try {
            contrasenaService.guardarContrasena(contrasena);
            return new ResponseEntity<>("Contraseña creada exitosamente", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Error al crear la contraseña: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la contraseña: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarContrasena(@PathVariable int id, @RequestBody ContrasenaModel contrasena) {
        try {
            contrasenaService.editarContrasena(id, contrasena);
            return new ResponseEntity<>("Contraseña editada exitosamente", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar la contraseña: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
