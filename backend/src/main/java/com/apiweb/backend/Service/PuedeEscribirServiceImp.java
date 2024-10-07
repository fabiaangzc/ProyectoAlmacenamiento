package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.PuedeEscribirModel;
import com.apiweb.backend.Repository.IPuedeEscribirRepository;

import jakarta.transaction.Transactional;

@Service
public class PuedeEscribirServiceImp implements IPuedeEscribirService {

    @Autowired
    IPuedeEscribirRepository puedeEscribirRepository;
    
    @Override
    public String crearPuedeEscribir(PuedeEscribirModel puedeEscribir) {
        if (puedeEscribirRepository.existsByUsuario_IdUsuarioAndDocumento_IdDocumento(
                puedeEscribir.getIdUsuario(), puedeEscribir.getIdDocumento())) {
            return "El usuario ya ha escrito este documento";
        }

        puedeEscribirRepository.save(puedeEscribir);
        return "El usuario a escrito el documento";
    }

    @Override
    @Transactional
    public String eliminarPuedeEscribir(Integer idEscribir) {
        if (puedeEscribirRepository.existsById(idEscribir)) {
            puedeEscribirRepository.deleteById(idEscribir);
            return "El usuario ya no puede escribir";
        } else {
            return "El usuario no existe.";
        }
    }
}