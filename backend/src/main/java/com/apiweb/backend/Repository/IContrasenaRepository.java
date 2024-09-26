package com.apiweb.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiweb.backend.Model.ContrasenaModel;

public interface IContrasenaRepository extends JpaRepository<ContrasenaModel, Integer>{
    
}
