package com.apiweb.backend.Repository;

import com.apiweb.backend.Model.CategoriaModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<CategoriaModel, Integer> {
    // futuras consultas 
}
