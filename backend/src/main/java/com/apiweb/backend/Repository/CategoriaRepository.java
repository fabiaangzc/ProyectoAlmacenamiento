package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer>{
    //Futuras consultas
}