package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.ValoracionModel;
import com.apiweb.backend.Repository.IValoracionRepository;
@Service
public class ValoracionServicelmp implements IValoracionService{
    @Autowired
    IValoracionRepository ValoracionRepository;
    @Override
    public String guardarValoracion(ValoracionModel valoracion) {
<<<<<<< HEAD:backend/src/main/java/com/apiweb/backend/Service/ValoracionServiceImp.java
        ValoracionRepository.save(valoracion);
        return "Su valoracion se subió correctamente";
=======
        if (valoracion.getIdValoracion() != null && valoracionRepository.existsById(valoracion.getIdValoracion())) {
            throw new IllegalArgumentException("Ya has valorado este documento");
        }
        if (valoracionRepository.existsByUsuario_IdUsuarioAndDocumento_IdDocumento(valoracion.getIdUsuario(), valoracion.getIdDocumento())) {
            throw new IllegalArgumentException("Ya has valorado este documento");
        }
        valoracionRepository.save(valoracion);
        return "La valoración fue dada correctamente";
>>>>>>> 0dc98072ca8529424783d78d45d8a3419d15ea12:backend/src/main/java/com/apiweb/backend/Service/ValoracionServicelmp.java
    }
}
