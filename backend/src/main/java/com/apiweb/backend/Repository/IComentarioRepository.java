package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.ComentarioModel;

public interface IComentarioRepository extends JpaRepository<ComentarioModel, Integer> {
    // futuras consultas 
}
