package com.apiweb.backend.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Exeption.RecursoNoEncontradoException;
import com.apiweb.backend.Model.ComentarioModel;
import com.apiweb.backend.Repository.IComentarioRepository;
import java.util.Optional; 

@Service
public class ComentarioServiceImp implements IComentarioService{
    @Autowired
    IComentarioRepository comentarioRepository;

    @Override
    public String guardarComentario(ComentarioModel comenario) {
        comentarioRepository.save(comenario);
        return "El comentario ha sido creado correctamente con ID " + comenario.getIdComentario();
    }

    @Override
    public ComentarioModel buscarComentarioPorId(int comentarioId) {
        Optional<ComentarioModel> comentarioRecuperado = comentarioRepository.findById(comentarioId);
        return comentarioRecuperado.orElseThrow(() -> new RecursoNoEncontradoException(
            "Error! El comentario con el Id " + comentarioId + ", no existe en la BD o el id es incorrecto"));
    }

    @Override
    public String editarComentario(int comentarioId, ComentarioModel comentario) {
        ComentarioModel comentarioExistente = buscarComentarioPorId(comentarioId);
        comentarioExistente.setContenido(comentario.getContenido());
        comentarioRepository.save(comentarioExistente);
        return "El comentario con ID " + comentarioId + " ha sido actualizado correctamente.";
    }

    @Override
    public String eliminarComentario(int comentarioId) {
        ComentarioModel comentarioExistente = buscarComentarioPorId(comentarioId);
        comentarioRepository.delete(comentarioExistente);
        return "El comentario con ID " + comentarioId + " ha sido eliminado correctamente.";
    }
}
