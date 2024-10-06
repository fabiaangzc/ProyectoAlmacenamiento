package com.apiweb.backend.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Exeption.RecursoNoEncontradoException;
import com.apiweb.backend.Model.ValoracionModel;
import com.apiweb.backend.Repository.IValoracionRepository;
import java.util.Optional;

@Service
public class ValoracionServiceImp implements IValoracionService{
    @Autowired
    IValoracionRepository valoracionRepository;

    @Override
    public String guardarValoracion(ValoracionModel valoracion){
        valoracionRepository.save(valoracion);
        return "La valoración fue creada correctamente con ID " + valoracion.getIdValoracion();
    }

    @Override
    public ValoracionModel buscarValoracionPorId(int valoracionId) {
        Optional<ValoracionModel> valoracionRecuperada = valoracionRepository.findById(valoracionId);
        return valoracionRecuperada.orElseThrow(() -> new RecursoNoEncontradoException(
            "Error! La valoración con el Id " + valoracionId + ", no existe en la BD o el id es incorrecto"));
    }

    @Override
    public String editarValoracion(int valoracionId, ValoracionModel valoracion) {
        ValoracionModel valoracionExistente = buscarValoracionPorId(valoracionId);
        valoracionExistente.setPuntuacion(valoracion.getPuntuacion()); 
        valoracionRepository.save(valoracionExistente);
        return "La valoración con ID " + valoracionId + " ha sido actualizada correctamente.";
    }

    @Override
    public String eliminarValoracion(int valoracionId) {
        ValoracionModel valoracionExistente = buscarValoracionPorId(valoracionId);
        valoracionRepository.delete(valoracionExistente);
        return "La valoración con ID " + valoracionId + " ha sido eliminada correctamente.";
    }
}