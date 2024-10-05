package com.apiweb.backend.Model;

import com.apiweb.backend.Model.ENUM.Visibilidad;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="documento")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class DocumentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocumento;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaModel categoria;

    @ManyToOne
    @JoinColumn(name = "idEscribir")
    private PuedeEscribirModel escribir;

    private String descripcion;
    private String url;

    @Enumerated(EnumType.STRING)
    private Visibilidad visibilidad;
    
}
