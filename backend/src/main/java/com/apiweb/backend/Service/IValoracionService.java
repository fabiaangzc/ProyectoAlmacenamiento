package com.apiweb.backend.Service;

import com.apiweb.backend.Model.ValoracionModel;
import java.util.List;

public interface IValoracionService {

  
    ValoracionModel guardarValoracion(ValoracionModel valoracion);

    // Obtener todas las valoraciones
    List<ValoracionModel> obtenerTodasLasValoraciones();

    // Obtener una valoración por ID
    ValoracionModel obtenerValoracionPorId(int idValoracion);

    // Actualizar una valoración existente
    boolean actualizarValoracion(int idValoracion, ValoracionModel valoracionActualizada);

    // Eliminar una valoración por ID
    boolean eliminarValoracion(int idValoracion);
}

