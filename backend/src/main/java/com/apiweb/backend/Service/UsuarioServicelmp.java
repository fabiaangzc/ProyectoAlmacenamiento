package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apiweb.backend.Model.UsuarioModel;
import com.apiweb.backend.Repository.IContrasenaRepository;
import com.apiweb.backend.Repository.IUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServicelmp implements IUsuarioService {
    
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IContrasenaRepository contrasenaRepository;

    // Método para crear un usuario
    @Override
    public String guardarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
        return "El usuario " + usuario.getNickname() + " fue creado correctamente.";
    }

    @Override
    @Transactional
    public String eliminarUsuario(Integer idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            contrasenaRepository.deleteByUsuario_IdUsuario(idUsuario);
            usuarioRepository.deleteById(idUsuario);
            

            return "Usuario y sus contraseñas han sido eliminados correctamente.";
        } else {
            return "El usuario no existe.";
        }
    }
}
