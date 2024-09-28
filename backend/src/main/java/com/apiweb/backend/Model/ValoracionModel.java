package com.apiweb.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "valoracion")
public class ValoracionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Asume que el ID se genera automáticamente
    @Column(name = "idValoracion")
    private int idValoracion;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    // Relación con la entidad Usuario (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    private UsuarioModel usuario;  // Asume que tienes un modelo UsuarioModel

    // Relación con la entidad Documento (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "idDocumento", referencedColumnName = "idDocumento", nullable = false)
    private DocumentoModel documento;  // Asume que tienes un modelo DocumentoModel

    // Constructor vacío
    public ValoracionModel() {}

    // Constructor con parámetros
    public ValoracionModel(int puntuacion, LocalDateTime fecha, UsuarioModel usuario, DocumentoModel documento) {
        this.puntuacion = puntuacion;
        this.fecha = fecha;
        this.usuario = usuario;
        this.documento = documento;
    }

    // Getters y Setters

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public DocumentoModel getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoModel documento) {
        this.documento = documento;
    }
}

