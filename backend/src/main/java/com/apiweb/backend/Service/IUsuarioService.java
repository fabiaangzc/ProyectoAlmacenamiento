package com.apiweb.backend.Service;

import com.apiweb.backend.Model.UsuarioModel;

public interface IUsuarioService {
    String guardarUsuario(UsuarioModel usuario);

    String eliminarUsuario(Integer idUsuario);
}
