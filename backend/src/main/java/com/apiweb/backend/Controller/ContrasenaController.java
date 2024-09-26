package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<String>crearContrasena(@RequestBody ContrasenaModel contrasena){
        return new ResponseEntity<>(contrasenaService.guardarContrasena(contrasena), HttpStatus.OK);
    }
    
}
