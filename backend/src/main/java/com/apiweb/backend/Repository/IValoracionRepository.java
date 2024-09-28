package com.apiweb.backend.Repository;

import com.apiweb.backend.Model.ValoracionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IValoracionRepository extends JpaRepository<ValoracionModel, Integer> {

}

