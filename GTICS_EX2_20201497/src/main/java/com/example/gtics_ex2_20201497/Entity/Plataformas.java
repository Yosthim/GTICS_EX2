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
@Table(name = "plataformas")
@JsonIgnoreProperties({"idPlataforma"})
public class Plataformas {
    @Id
    @Column(name = "idplataforma")
    private int idPlataforma;
    private String nombre;
    private String descripcion;
}
