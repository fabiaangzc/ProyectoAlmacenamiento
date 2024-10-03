package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.CategoriaModel;
import com.apiweb.backend.Service.ICategoriaService;

@RestController
@RequestMapping("/apiweb/v1/categorias")
public class CategoriaController {

    @Autowired
    ICategoriaService categoriaService;

    @PostMapping("/insertar")
    public ResponseEntity<String> crearCategoria(@RequestBody CategoriaModel categoria) {
        try {
            String response = categoriaService.guardarCategoria(categoria);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
