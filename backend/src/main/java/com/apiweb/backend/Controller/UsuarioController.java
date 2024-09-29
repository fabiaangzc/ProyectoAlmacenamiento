package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.UsuarioModel;
import com.apiweb.backend.Service.IUsuarioService;

@RestController
@RequestMapping ("/apiweb/v1/usuarios")
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;
    @PostMapping ("/insertar")
    public ResponseEntity<String>crearUsuario(@RequestBody UsuarioModel usuario){
        return new ResponseEntity<String>(usuarioService.guardarUsuario(usuario), HttpStatus.OK);
    }
}
