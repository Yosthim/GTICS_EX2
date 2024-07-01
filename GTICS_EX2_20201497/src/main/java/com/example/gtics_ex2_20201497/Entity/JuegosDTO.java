package com.example.gtics_ex2_20201497.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuegosDTO {
    private int idJuego;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String image;
    private int idgenero;
    private int idplataforma;
    private int ideditora;
    private int iddistribuidora;
}
