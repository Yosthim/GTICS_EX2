package com.example.gtics_ex2_20201497.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "generos")
@JsonIgnoreProperties({"idGenero"})
public class Generos {
    @Id
    @Column(name = "idgenero")
    private int idGenero;
    private String nombre;
    private String descripcion;
}
