package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.PuedeVisualizarModel;
import com.apiweb.backend.Repository.IPuedeVisualizarRepository;

@Service
public class PuedeVisualizarServiceImp implements IPuedeVisualizarService {

    @Autowired 
    IPuedeVisualizarRepository puedeVisualizarRepository;
    
    @Override
    public String crearPuedeVisualizar(PuedeVisualizarModel puedeVisualizar) {

        if (puedeVisualizarRepository.existsByUsuario_IdUsuarioAndDocumento_IdDocumento(
                puedeVisualizar.getIdUsuario(), puedeVisualizar.getIdDocumento())) {
            return "El usuario ya ha visualizado este documento";
        }

        puedeVisualizarRepository.save(puedeVisualizar);
        return "El usuario ahora tiene acceso para visualizar el documento";
    }

}
