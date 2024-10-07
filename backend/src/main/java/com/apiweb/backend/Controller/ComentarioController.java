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
import com.apiweb.backend.Model.ComentarioModel;
import com.apiweb.backend.Service.IComentarioService;

@RestController
@RequestMapping("/apiweb/v1/comentarios")
public class ComentarioController {
    @Autowired
    IComentarioService comentarioService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearComentario(@RequestBody ComentarioModel comentario) {
        try {
            return new ResponseEntity<>(comentarioService.guardarComentario(comentario), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarComentarioPorId(@PathVariable int id) {
        try {
            ComentarioModel comentario = comentarioService.buscarComentarioPorId(id);
            return ResponseEntity.ok(comentario);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarComentario(@PathVariable int id, @RequestBody ComentarioModel comentario) {
        try {
            return new ResponseEntity<>(comentarioService.editarComentario(id, comentario), HttpStatus.OK);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable int id) {
        try {
            return new ResponseEntity<>(comentarioService.eliminarComentario(id), HttpStatus.OK);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el comentario: " + e.getMessage());
        }
    }
}
