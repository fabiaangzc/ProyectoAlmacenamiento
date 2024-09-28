package com.apiweb.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private int idCategoria;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "SubIdCategoria", referencedColumnName = "idCategoria")
    private CategoriaModel subCategoria;

    @OneToMany(mappedBy = "subCategoria")
    private List<CategoriaModel> subCategorias;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaModel getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(CategoriaModel subCategoria) {
        this.subCategoria = subCategoria;
    }

    public List<CategoriaModel> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(List<CategoriaModel> subCategorias) {
        this.subCategorias = subCategorias;
    }
}
