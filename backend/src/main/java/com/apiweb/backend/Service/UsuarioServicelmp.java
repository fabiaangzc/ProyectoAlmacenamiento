package com.apiweb.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Exeption.RecursoNoEncontradoException;
import com.apiweb.backend.Model.UsuarioModel;
import com.apiweb.backend.Repository.IUsuarioRepository;
import java.util.Optional;
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

    @Override
    public UsuarioModel buscarUsuarioPorId(Integer idUsuario) {
        Optional<UsuarioModel> usuarioRecuperado = usuarioRepository.findById(idUsuario);
        return usuarioRecuperado.orElseThrow(() -> new RecursoNoEncontradoException(
            "Error! El usuario con el Id " + idUsuario + ", no existe en la BD o el id es incorrecto"));
    }

    @Override
    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public String editarUsuario(Integer idUsuario, UsuarioModel usuario) {
       UsuarioModel usuarioRecuperado = buscarUsuarioPorId(idUsuario);
       usuarioRecuperado.setNickname(usuario.getNickname());
       usuarioRecuperado.setNombre(usuario.getNombre());
       usuarioRecuperado.setEmail(usuario.getEmail());
       usuarioRecuperado.setCiudad(usuario.getCiudad());
       usuarioRecuperado.setDepartamento(usuario.getDepartamento());
       usuarioRepository.save(usuarioRecuperado);
       
       return "El usuario con Id " + idUsuario + " ha sido actualizado correctamente.";
    }
}
