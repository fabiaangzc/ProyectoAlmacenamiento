package com.apiweb.backend;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nombre;
    private String email;
    private String nickname;
    private String ciudad;
    private String departamento;
    private String preguntaSecreta;
    private String respuestaSecreta;

}
