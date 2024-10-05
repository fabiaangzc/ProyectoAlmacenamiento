package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.ComentarioModel;
import com.apiweb.backend.Service.IComentarioService;

@RestController
@RequestMapping("/apiweb/v1/comentarios")
public class ComentarioController {
    @Autowired
    IComentarioService comentarioService;

    @PostMapping("/insertar")
    public ResponseEntity<String>crearComentario(@RequestBody ComentarioModel comentario){
       try {
           String response = comentarioService.guardarComentario(comentario);
           return new ResponseEntity<>(response, HttpStatus.OK);
       } catch (IllegalArgumentException e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }
}
