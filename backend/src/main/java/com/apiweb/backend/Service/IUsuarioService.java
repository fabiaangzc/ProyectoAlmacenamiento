package com.apiweb.backend.Service;

import java.util.List;

import com.apiweb.backend.Model.UsuarioModel;

public interface IUsuarioService {

    String guardarUsuario(UsuarioModel usuario);
    UsuarioModel buscarUsuarioPorId(Integer idUsuario);
    List<UsuarioModel> listarUsuarios();
    String eliminarUsuario(Integer idUsuario);
    String editarUsuario(Integer idUsuario, UsuarioModel usuario);
}
