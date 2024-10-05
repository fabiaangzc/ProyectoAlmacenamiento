package com.apiweb.backend.Service;

import com.apiweb.backend.Model.CategoriaModel;

import java.util.List;

public interface ICategoriaService {
<<<<<<< HEAD
    String guardarCategoria(CategoriaModel categoria);
    CategoriaModel buscarCategoriaPorId(int categoriaId);
    List<CategoriaModel> listarCategorias();
    String editarCategoria(int categoriaId, CategoriaModel categoria);

=======
    String guardarCategoria(CategoriaModel Categoria);
    void eliminarCategoria(Integer idCategoria);
>>>>>>> 0dc98072ca8529424783d78d45d8a3419d15ea12
}
