package com.apiweb.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@Table (name="puededescargar")
@AllArgsConstructor
@NoArgsConstructor

public class PuedeDescargarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idDescarga;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    public DocumentoModel documento;

    @ManyToOne
    @JoinColumn(name ="idUsuario")
    public UsuarioModel Usuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @PrePersist
    protected void onCreate() {
        fecha = new Date();
    }

}
