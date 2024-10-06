package com.apiweb.backend.Service;

import com.apiweb.backend.Model.ValoracionModel;

public interface IValoracionService {
    String guardarValoracion(ValoracionModel valoracion);
    ValoracionModel buscarValoracionPorId(int valoracionId); 
    String editarValoracion(int valoracionId, ValoracionModel valoracion); 
    String eliminarValoracion(int valoracionId); 
}