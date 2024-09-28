package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.PuedeVisualizarModel;
import com.apiweb.backend.Repository.IPuedeVisualizarRepository;
@Service
public class PuedeVisualizarServiceImp implements IPuedeVisualizarService {
    @Autowired IPuedeVisualizarRepository puedeVisualizarRepository;
    @Override
    public String crearPuedeVisualizar(PuedeVisualizarModel puedeVisualizar) {
        puedeVisualizarRepository.save(puedeVisualizar);
        return "El usuario ya tiene acceso para visualizar el documento";
    }

}
