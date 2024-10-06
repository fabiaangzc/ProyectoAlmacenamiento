package com.apiweb.backend.Service;

import com.apiweb.backend.Exeption.RecursoNoEncontradoException;
import com.apiweb.backend.Model.HistorialAccionesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.apiweb.backend.Repository.IHistorialAccionesRepository;

@Service
public class HistorialAccionesServiceImp implements IHistorialAccionesService {

    @Autowired
    private IHistorialAccionesRepository historialAccionesRepository;

    @Override
    public List<HistorialAccionesModel> obtenerHistorialAcciones() {
        return historialAccionesRepository.findAll();
    }

    @Override
    public HistorialAccionesModel guardarHistorial(HistorialAccionesModel historial) {
        return historialAccionesRepository.save(historial);
    }

    @Override
    public HistorialAccionesModel buscarHistorialPorId(int idHistorial) {
        Optional<HistorialAccionesModel> historial = historialAccionesRepository.findById(idHistorial);
        return historial.orElseThrow(() -> new RecursoNoEncontradoException(
                "Historial con ID " + idHistorial + " no encontrado."));
    }

    @Override
    public String eliminarHistorial(int idHistorial) {
        HistorialAccionesModel historial = buscarHistorialPorId(idHistorial);
        historialAccionesRepository.delete(historial);
        return "Historial con ID " + idHistorial + " ha sido eliminado.";
    }
}
