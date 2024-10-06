package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.HistorialAccionesModel;

public interface IHistorialAccionesRepository extends JpaRepository<HistorialAccionesModel, Integer> {
    // futuras consultas
}
