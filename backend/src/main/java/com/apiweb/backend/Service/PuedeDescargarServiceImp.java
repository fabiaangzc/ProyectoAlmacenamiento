package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.PuedeDescargarModel;
import com.apiweb.backend.Repository.IPuedeDescargarRepository;
@Service
public class PuedeDescargarServiceImp implements IPuedeDescargarService {
    @Autowired IPuedeDescargarRepository puedeDescargarRepository;
    @Override
    public String crearPuedeDescargar(PuedeDescargarModel puedeDescargar) {
        puedeDescargarRepository.save(puedeDescargar);
        return "La descarga se ha realizado con éxito por el usuario con ID: "+puedeDescargar.getUsuario().getIdUsuario() 
        +" a las " +puedeDescargar.getFecha();

    }
}
