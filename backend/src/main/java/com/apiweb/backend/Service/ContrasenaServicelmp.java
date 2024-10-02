package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.ContrasenaModel;
import com.apiweb.backend.Repository.IContrasenaRepository;

@Service
public class ContrasenaServicelmp implements IContrasenaService {
    @Autowired
    IContrasenaRepository contrasenaRepository;

    @Override
    public String guardarContrasena(ContrasenaModel contrasena) {
        contrasenaRepository.save(contrasena);
        return "La contraseña: " + contrasena.getClave() + " fue guardada correctamente";
    }

    @Override
    public void eliminarContrasena(Integer idUsuario) {
        contrasenaRepository.deleteByUsuario_IdUsuario(idUsuario);
    }
    
}
