package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.DocumentoModel;

public interface IDocumentoRepository extends JpaRepository<DocumentoModel, Integer> {
    
}
