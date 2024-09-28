package com.apiweb.backend.Model;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name="puededescargar")
@AllArgsConstructor
@NoArgsConstructor

public class PuedeDescargarModel {
    @Id
    public Integer idDescarga;
    public Integer idDocumento;
    public Integer idUsuario;
    public Date hora;
    public Date fecha;

}
