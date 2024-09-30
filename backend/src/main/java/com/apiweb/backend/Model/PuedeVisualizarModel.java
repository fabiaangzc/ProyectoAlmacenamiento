package com.apiweb.backend.Model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name="puedevisualizar")
@AllArgsConstructor
@NoArgsConstructor

public class PuedeVisualizarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idVisualizacion;

    public Date fecha;

    @ManyToOne
    @JoinColumn(name ="idUsuario")
    public UsuarioModel Usuario;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    public DocumentoModel documento;

}
