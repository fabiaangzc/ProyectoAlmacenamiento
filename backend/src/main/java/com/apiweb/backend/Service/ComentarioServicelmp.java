package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.ComentarioModel;
import com.apiweb.backend.Repository.IComentarioRepository;

@Service
public class ComentarioServicelmp implements IComentarioService{
    @Autowired
    IComentarioRepository comentarioRepository;

    @Override
    public String guardarComentario(ComentarioModel comenario) {
        comentarioRepository.save(comenario);
        return "El comentario se a realizado correctamente.";
    }

}
