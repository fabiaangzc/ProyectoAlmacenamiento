package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.CategoriaModel;
import com.apiweb.backend.Repository.CategoriaRepository;

@Service
public class CategoriaServicelmp implements CategoriaService{
    @Autowired
    CategoriaRepository CategoriaRepository;
    @Override
    public String guardarCategoria(CategoriaModel Categoria){
        CategoriaRepository.save(Categoria);
        return "La categoria " + Categoria.getCategoria() + " fue creado correctamente";
    }
}