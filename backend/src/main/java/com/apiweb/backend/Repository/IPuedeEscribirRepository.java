package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.PuedeEscribirModel;

public interface IPuedeEscribirRepository extends JpaRepository<PuedeEscribirModel, Integer>{
    boolean existsByUsuario_IdUsuarioAndDocumento_IdDocumento(Integer idUsuario, Integer idDocumento);
}
