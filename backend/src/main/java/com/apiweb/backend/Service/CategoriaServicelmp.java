package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.CategoriaModel;
import com.apiweb.backend.Repository.ICategoriaRepository;

@Service
public class CategoriaServicelmp implements ICategoriaService {

    @Autowired
    ICategoriaRepository categoriaRepository;

    @Override
    public String guardarCategoria(CategoriaModel categoria) {
        if (categoria.getIdCategoria() != null && categoriaRepository.existsById(categoria.getIdCategoria())) {
            throw new IllegalArgumentException("La categoría con el ID proporcionado ya existe.");
        }
        categoriaRepository.save(categoria);
        return "La categoría " + categoria.getNombre() + " fue creada correctamente";
    }

    @Override
    public void eliminarCategoria(Integer idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}