package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.CategoriaModel;
import com.apiweb.backend.Repository.ICategoriaRepository;

@Service
public class CategoriaServicelmp implements ICategoriaService{
    @Autowired
    ICategoriaRepository CategoriaRepository;
    @Override
    public String guardarCategoria(CategoriaModel Categoria){
        CategoriaRepository.save(Categoria);
        return "La categoria " + Categoria.getNombre() + " fue creada correctamente";
    }
}