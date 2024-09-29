package com.apiweb.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apiweb.backend.Model.CategoriaModel;
import com.apiweb.backend.Service.ICategoriaService;

@RestController
@RequestMapping("/apiweb/v1/categorias")
public class CategoriaController {

    @Autowired
    ICategoriaService categoriaService;
    
    @PostMapping("/insertar")
    public ResponseEntity<String> crearCategoria(@RequestBody CategoriaModel categoria) {
        categoriaService.guardarCategoria(categoria);
        return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.OK);
    }
}