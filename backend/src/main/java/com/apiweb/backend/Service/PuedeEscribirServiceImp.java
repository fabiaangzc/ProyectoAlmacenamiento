package com.apiweb.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiweb.backend.Model.PuedeEscribirModel;
import com.apiweb.backend.Repository.IPuedeEscribirRepository;

@Service
public class PuedeEscribirServiceImp implements IPuedeEscribirService {
    @Autowired IPuedeEscribirRepository puedeEscribirRepository;
    @Override
    public String crearPuedeEscribir(PuedeEscribirModel puedeEscribir) {
       puedeEscribirRepository.save(puedeEscribir);
       return "El usuario ya puede escribir";
    }
    

}
