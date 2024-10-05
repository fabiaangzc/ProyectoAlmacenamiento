package com.apiweb.backend.Model;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "puedevisualizar")
public class PuedeVisualizarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVisualizacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    private DocumentoModel documento;

    public Integer getIdUsuario() {
        return usuario != null ? usuario.getIdUsuario() : null;
    }

    public Integer getIdDocumento() {
        return documento != null ? documento.getIdDocumento() : null;
    }
}
