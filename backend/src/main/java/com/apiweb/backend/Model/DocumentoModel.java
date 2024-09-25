package com.apiweb.backend.Model;

import jakarta.persistence.Entity;
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
    private Integer idDocumento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

    private String descripcion;
    private String url;

    private Visibilidad visibilidad;

    public enum Visibilidad {
        Público,
        Privado
    }
}
