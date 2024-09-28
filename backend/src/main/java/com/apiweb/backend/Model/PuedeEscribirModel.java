package com.apiweb.backend.Model;

import java.util.Date;

import com.apiweb.backend.Model.ENUM.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
    public Integer idEscribir;
    public Date fecha;
    @Column (name="usuario_idUsuario")
    public Integer idUsuario;
    public Integer idDocumento;
    @Column (name="rol")
    @Enumerated (EnumType.STRING)
    public Rol rol;

}
