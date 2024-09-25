package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.UsuarioModel;
import com.apiweb.backend.Repository.IIusuarioRepository;

@Service
public class UsuarioServicelmp implements IIsuarioService{
    @Autowired
    IIusuarioRepository usuarioRepository;
    @Override
    public String guardarUsuario(UsuarioModel usuario){
        usuarioRepository.save(usuario);
        return "El usuario " + usuario.getNickname() + " fue creado correctamente";
    }
}

