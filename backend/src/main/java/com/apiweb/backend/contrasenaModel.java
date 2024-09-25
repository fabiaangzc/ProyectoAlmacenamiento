package com.apiweb.backend;

import java.time.LocalDateTime;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class contrasena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContraseña;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private String clave;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private LocalDateTime fechaCreacion;

    public enum Estado {
        Activa,
        Expirada
    }


}
