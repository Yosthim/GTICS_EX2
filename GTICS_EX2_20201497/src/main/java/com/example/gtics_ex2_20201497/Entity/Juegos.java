package com.example.gtics_ex2_20201497.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "juegos")
public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego")
    private int idJuego;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String image;
    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Generos genero;
    @ManyToOne
    @JoinColumn(name = "idplataforma")
    private Plataformas plataforma;
    @ManyToOne
    @JoinColumn(name = "ideditora")
    private Editoras editora;
    @ManyToOne
    @JoinColumn(name = "iddistribuidora")
    private Distribuidoras distribuidora;
}
