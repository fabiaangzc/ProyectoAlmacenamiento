package com.apiweb.backend.Model;

import java.time.LocalDateTime;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contrasena")


public class ContrasenaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContraseña;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

    private String clave;
    @Enumerated(EnumType.STRING)
    
    private Estado estado;

    private LocalDateTime fechaCreacion;

    public enum Estado {
        Activa,
        Expirada
    }

}
    
