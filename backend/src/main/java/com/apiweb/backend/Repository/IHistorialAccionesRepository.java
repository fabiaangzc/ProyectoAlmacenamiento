package com.apiweb.backend.Repository;

import com.apiweb.backend.Model.HistorialAccionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistorialAccionesRepository extends JpaRepository<HistorialAccionesModel, Integer> {
    List<HistorialAccionesModel> findByUsuario_IdUsuario(int idUsuario); 
}


