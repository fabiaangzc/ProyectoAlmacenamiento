package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.PuedeDescargarModel;

public interface IPuedeDescargarRepository extends JpaRepository<PuedeDescargarModel, Integer>{
    
}
