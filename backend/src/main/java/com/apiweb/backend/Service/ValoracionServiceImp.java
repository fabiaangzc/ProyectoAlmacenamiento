package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.ValoracionModel;
import com.apiweb.backend.Repository.IValoracionRepository;
@Service
public class ValoracionServicelmp implements IValoracionService{
    @Autowired
    IValoracionRepository ValoracionRepository;
    @Override
    public String guardarValoracion(ValoracionModel valoracion) {
        ValoracionRepository.save(valoracion);
        return "Su valoracion se subió correctamente";
    }
    
}
