package com.apiweb.backend.Service;

import com.apiweb.backend.Model.ContrasenaModel;

public interface IContrasenaService {
    void guardarContrasena(ContrasenaModel contrasena);
    void editarContrasena(int id, ContrasenaModel contrasena);
    void expirarContraseñasAnteriores(Integer idUsuario);
}