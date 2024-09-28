package com.apiweb.backend.Service;

import com.apiweb.backend.Model.CategoriaModel;
import com.apiweb.backend.Repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ICategoriaServiceImp implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaModel> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public CategoriaModel obtenerCategoriaPorId(int id) {
        Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    @Override
    public CategoriaModel guardarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(int id) {
        categoriaRepository.deleteById(id);
    }
}

