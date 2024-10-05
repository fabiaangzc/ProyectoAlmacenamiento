package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.ValoracionModel;
import com.apiweb.backend.Repository.IValoracionRepository;


@Service
public class ValoracionServicelmp implements IValoracionService{
    @Autowired
    IValoracionRepository valoracionRepository;

    @Override
    public String guardarValoracion(ValoracionModel valoracion) {
        if (valoracion.getIdValoracion() != null && valoracionRepository.existsById(valoracion.getIdValoracion())) {
            throw new IllegalArgumentException("Ya has valorado este documento");
        }
        if (valoracionRepository.existsByUsuario_IdUsuarioAndDocumento_IdDocumento(valoracion.getIdUsuario(), valoracion.getIdDocumento())) {
            throw new IllegalArgumentException("Ya has valorado este documento");
        }
        valoracionRepository.save(valoracion);
        return "La valoración fue dada correctamente";
    }
}
