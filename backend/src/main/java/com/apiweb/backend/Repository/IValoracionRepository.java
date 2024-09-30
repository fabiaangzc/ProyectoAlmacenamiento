package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.ValoracionModel;

public interface IValoracionRepository extends JpaRepository<ValoracionModel, Integer>{
    //Futuras consultas
}
