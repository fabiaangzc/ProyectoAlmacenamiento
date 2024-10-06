package com.apiweb.backend.Repository;

import com.apiweb.backend.Model.ContrasenaModel;
import com.apiweb.backend.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IContrasenaRepository extends JpaRepository<ContrasenaModel, Integer> {
    List<ContrasenaModel> findTop3ByUsuarioOrderByFechaCreacionDesc(UsuarioModel usuario);

    @Modifying
    @Transactional
    @Query("UPDATE ContrasenaModel c SET c.estado = 'Expirada' WHERE c.usuario.idUsuario = :idUsuario AND c.estado = 'Activa'")
    void expirarContraseñasAnteriores(int idUsuario);
}