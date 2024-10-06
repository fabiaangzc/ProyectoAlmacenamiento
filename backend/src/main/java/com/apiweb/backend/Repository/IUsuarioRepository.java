package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiweb.backend.Model.UsuarioModel;
@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer>{
    //Futuras consultas
}
