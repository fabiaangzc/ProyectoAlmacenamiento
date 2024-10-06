package com.apiweb.backend.Service;

import com.apiweb.backend.Model.ComentarioModel;

public interface IComentarioService {
    String guardarComentario(ComentarioModel comenario); 
    ComentarioModel buscarComentarioPorId(int comentarioId); 
    String editarComentario(int comentarioId, ComentarioModel comentario); // Update
    String eliminarComentario(int comentarioId); 
}