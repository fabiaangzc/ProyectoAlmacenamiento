package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiweb.backend.Model.CategoriaModel;
import com.apiweb.backend.Service.CategoriaService;

@RestController
@RequestMapping ("/apiweb/v1/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/insertar")
    public ResponseEntity<String> crearCategoria(@RequestBody CategoriaModel categoria) {
        return new ResponseEntity<String>(categoriaService.guardarCategoria(categoria), HttpStatus.OK);
    }
}

