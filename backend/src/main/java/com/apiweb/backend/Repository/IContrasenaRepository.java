package com.apiweb.backend.Repository;

import com.apiweb.backend.Model.ContrasenaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContrasenaRepository extends JpaRepository<ContrasenaModel, Integer>  {
    //Futuras consultas
}