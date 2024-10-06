package com.apiweb.backend.Service;

import java.util.List;
import com.apiweb.backend.Model.HistorialAccionesModel;


public interface IHistorialAccionesService {

    List<HistorialAccionesModel> obtenerHistorialAcciones();
    HistorialAccionesModel guardarHistorial(HistorialAccionesModel historial);
    HistorialAccionesModel buscarHistorialPorId(int idHistorial);
    String eliminarHistorial(int idHistorial);

}
