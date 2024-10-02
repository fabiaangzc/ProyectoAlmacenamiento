package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.UsuarioModel;

public interface IIusuarioRepository extends JpaRepository<UsuarioModel, Integer>{
    //Futuras consultas
}
