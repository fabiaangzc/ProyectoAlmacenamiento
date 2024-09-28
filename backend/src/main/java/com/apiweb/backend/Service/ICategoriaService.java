package com.apiweb.backend.Service;

import com.apiweb.backend.Model.CategoriaModel;
import java.util.List;

public interface ICategoriaService {
    
    List<CategoriaModel> obtenerTodasLasCategorias();
    
    CategoriaModel obtenerCategoriaPorId(int id);
    
    CategoriaModel guardarCategoria(CategoriaModel categoria);
    
    void eliminarCategoria(int id);
}
