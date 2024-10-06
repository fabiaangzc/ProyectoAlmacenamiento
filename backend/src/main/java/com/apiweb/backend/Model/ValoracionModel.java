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
    private LocalDate fecha;  

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    private DocumentoModel documento;

    private Byte puntuacion;

    public void setPuntuacion(Byte puntuacion) {
        if (puntuacion < 1 || puntuacion > 5) {
            throw new IllegalArgumentException("La puntuación debe estar entre 1 y 5");
        }
        this.puntuacion = puntuacion;
    }

    public Integer getIdUsuario() {
        return usuario != null ? usuario.getIdUsuario() : null;
    }

    public Integer getIdDocumento() {
        return documento != null ? documento.getIdDocumento() : null;
    }
}
