package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apiweb.backend.Model.ValoracionModel;

public interface IValoracionRepository extends JpaRepository<ValoracionModel, Integer> {
    boolean existsByUsuario_IdUsuarioAndDocumento_IdDocumento(Integer idUsuario, Integer idDocumento);
}
