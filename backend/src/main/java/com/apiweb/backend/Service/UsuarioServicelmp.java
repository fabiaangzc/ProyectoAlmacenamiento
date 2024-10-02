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
        // Comprobar si el usuario existe
        if (usuarioRepository.existsById(idUsuario)) {
            // Eliminar todas las contraseñas asociadas al usuario
            contrasenaRepository.deleteByUsuario_IdUsuario(idUsuario); // Esto eliminará las contraseñas

            // Eliminar el usuario
            usuarioRepository.deleteById(idUsuario);

            return "Usuario y sus contraseñas han sido eliminados correctamente.";
        } else {
            return "El usuario no existe.";
        }
    }
}
