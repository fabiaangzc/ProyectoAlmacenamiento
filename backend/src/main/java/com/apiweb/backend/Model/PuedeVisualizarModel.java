package com.apiweb.backend.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name="puedevisualizar")
@AllArgsConstructor
@NoArgsConstructor

public class PuedeVisualizarModel {
    @Id
    public Integer idVisualizacion;
    public Date fecha;
    public Integer idUsuario;
    public Integer idDocumento;

}
