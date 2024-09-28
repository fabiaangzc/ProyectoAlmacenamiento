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

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> obtenerCategoriaPorId(@PathVariable int id) {
        CategoriaModel categoria = categoriaService.obtenerCategoriaPorId(id);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable int id) {
        categoriaService.eliminarCategoria(id);
        return new ResponseEntity<>("Categoría eliminada exitosamente", HttpStatus.OK);
    }
}

