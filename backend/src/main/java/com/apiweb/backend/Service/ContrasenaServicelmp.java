package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apiweb.backend.Model.ContrasenaModel;
import com.apiweb.backend.Repository.IContrasenaRepository;

import java.util.List;

@Service
public class ContrasenaServicelmp implements IContrasenaService {

    @Autowired
    private IContrasenaRepository contrasenaRepository;

    @Override
    @Transactional
    public void guardarContrasena(ContrasenaModel contrasena) {
        List<ContrasenaModel> recientes = contrasenaRepository.findTop3ByUsuarioOrderByFechaCreacionDesc(contrasena.getUsuario());

        for (ContrasenaModel reciente : recientes) {
            if (reciente.getClave().equals(contrasena.getClave())) {
                throw new IllegalArgumentException("La contraseña ha sido utilizada recientemente, por favor elija una nueva");
            }
        }

        expirarContraseñasAnteriores(contrasena.getUsuario().getIdUsuario());

        contrasenaRepository.save(contrasena);
    }

    @Override
    public void editarContrasena(int id, ContrasenaModel contrasena) {
        List<ContrasenaModel> recientes = contrasenaRepository.findTop3ByUsuarioOrderByFechaCreacionDesc(contrasena.getUsuario());

        for (ContrasenaModel reciente : recientes) {
            if (reciente.getClave().equals(contrasena.getClave())) {
                throw new IllegalArgumentException("La contraseña ha sido utilizada recientemente, por favor elija una nueva");
            }
        }

        expirarContraseñasAnteriores(contrasena.getUsuario().getIdUsuario());

        contrasenaRepository.save(contrasena);
    }

    @Override
    @Transactional
    public void expirarContraseñasAnteriores(Integer idUsuario) {
        contrasenaRepository.expirarContraseñasAnteriores(idUsuario);
    }
}