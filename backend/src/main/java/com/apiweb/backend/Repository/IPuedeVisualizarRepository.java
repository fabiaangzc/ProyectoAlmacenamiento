package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.PuedeVisualizarModel;

public interface IPuedeVisualizarRepository extends JpaRepository<PuedeVisualizarModel, Integer> {
    
}
