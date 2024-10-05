package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apiweb.backend.Model.UsuarioModel;
import com.apiweb.backend.Repository.IUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServicelmp implements IUsuarioService {
    
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public String guardarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
        return "El usuario " + usuario.getNickname() + " fue creado correctamente.";
    }

    @Override
    @Transactional
    public String eliminarUsuario(Integer idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuarioRepository.deleteById(idUsuario);
            return "Usuario ha sido eliminados correctamente.";
        } else {
            return "El usuario no existe.";
        }
    }
}
