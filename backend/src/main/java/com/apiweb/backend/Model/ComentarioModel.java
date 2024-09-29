package com.apiweb.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Table(name = "Comentario")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ComentarioModel {
    @Id
    private Integer idComentario;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    private DocumentoModel documento;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "SubIdComentario")
    private ComentarioModel subComentario;
    
}
