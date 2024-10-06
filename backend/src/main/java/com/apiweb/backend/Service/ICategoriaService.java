package com.apiweb.backend.Service;

import com.apiweb.backend.Model.CategoriaModel;

import java.util.List;

public interface ICategoriaService {

    String guardarCategoria(CategoriaModel categoria);
    CategoriaModel buscarCategoriaPorId(int categoriaId);
    List<CategoriaModel> listarCategorias();
    String editarCategoria(int categoriaId, CategoriaModel categoria);

}
