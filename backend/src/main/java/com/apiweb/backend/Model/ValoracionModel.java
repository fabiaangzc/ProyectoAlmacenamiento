package com.apiweb.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "valoracion")
public class ValoracionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValoracion;
    private Integer puntuacion; 
    private LocalDate fecha; 
    private Integer idUsuario; 
    private Integer idDocumento; 
}
