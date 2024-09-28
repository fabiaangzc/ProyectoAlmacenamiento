package com.apiweb.backend.Service;

import com.apiweb.backend.Model.ValoracionModel;
import com.apiweb.backend.Repository.IValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IValoracionServiceImp implements IValoracionService {

    @Autowired
    private IValoracionRepository valoracionRepository;

    // Guardar una nueva valoración
    @Override
    public ValoracionModel guardarValoracion(ValoracionModel valoracion) {
        return valoracionRepository.save(valoracion);
    }

    // Obtener todas las valoraciones
    @Override
    public List<ValoracionModel> obtenerTodasLasValoraciones() {
        return valoracionRepository.findAll();
    }

    // Obtener una valoración por ID
    @Override
    public ValoracionModel obtenerValoracionPorId(int idValoracion) {
        Optional<ValoracionModel> valoracion = valoracionRepository.findById(idValoracion);
        return valoracion.orElse(null);
    }

    // Actualizar una valoración existente
    @Override
    public boolean actualizarValoracion(int idValoracion, ValoracionModel valoracionActualizada) {
        if (valoracionRepository.existsById(idValoracion)) {
            valoracionActualizada.setIdValoracion(idValoracion);  // Asegurar que el ID no cambie
            valoracionRepository.save(valoracionActualizada);
            return true;
        }
        return false;
    }

    // Eliminar una valoración por ID
    @Override
    public boolean eliminarValoracion(int idValoracion) {
        if (valoracionRepository.existsById(idValoracion)) {
            valoracionRepository.deleteById(idValoracion);
            return true;
        }
        return false;
    }
}

