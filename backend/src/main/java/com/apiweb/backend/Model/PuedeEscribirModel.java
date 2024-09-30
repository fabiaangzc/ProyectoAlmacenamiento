package com.apiweb.backend.Model;

import java.util.Date;

import com.apiweb.backend.Model.ENUM.Rol;

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
@Table (name="puedeescribir")
@AllArgsConstructor
@NoArgsConstructor

public class PuedeEscribirModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idEscribir;

    public Date fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    private DocumentoModel documento;

    public Rol rol;

}
