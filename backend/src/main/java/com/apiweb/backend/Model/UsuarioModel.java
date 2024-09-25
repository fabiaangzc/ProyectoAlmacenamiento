package com.apiweb.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")

public class UsuarioModel {
    @Id
    private Integer idUsuario;

    private String nombre;
    private String email;
    private String nickname;
    private String ciudad;
    private String departamento;
    private String preguntaSecreta;
    private String respuestaSecreta;

}
