package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.UsuarioModel;
import com.apiweb.backend.Repository.IUsuarioRepository;

@Service
public class UsuarioServicelmp implements IUsuarioService{
    @Autowired
    IUsuarioRepository usuarioRepository;
    @Override
    public String guardarUsuario(UsuarioModel usuario){
        usuarioRepository.save(usuario);
        return "El usuario " + usuario.getNickname() + " fue creado correctamente";
    }
}
