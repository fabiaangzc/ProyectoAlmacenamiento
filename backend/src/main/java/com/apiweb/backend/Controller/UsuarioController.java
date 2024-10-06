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

import com.apiweb.backend.Model.UsuarioModel;
import com.apiweb.backend.Service.IUsuarioService;

@RestController
@RequestMapping ("/apiweb/v1/usuarios")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping ("/insertar")
    public ResponseEntity<String>crearUsuario(@RequestBody UsuarioModel usuario){
        return new ResponseEntity<String>(usuarioService.guardarUsuario(usuario), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?>buscarUsuarioPorId(@PathVariable int id){
        try {
            UsuarioModel usuario = usuarioService.buscarUsuarioPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping ("/listarUsuarios")
    public ResponseEntity<?>listarUsuarios(){
        return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<String>editarUsuario(@PathVariable int id, @RequestBody UsuarioModel usuario){
        try {
            return new ResponseEntity<>(usuarioService.editarUsuario(id, usuario), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String>eliminarUsuario(@PathVariable("id") Integer idUsuario){
        return new ResponseEntity<>(usuarioService.eliminarUsuario(idUsuario), HttpStatus.OK);
    }
}
