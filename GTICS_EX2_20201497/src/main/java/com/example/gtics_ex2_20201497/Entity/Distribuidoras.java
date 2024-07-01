package com.example.gtics_ex2_20201497.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@Entity
@Table(name = "distribuidoras")
@JsonIgnoreProperties({"idDistribuidora"})
public class Distribuidoras {
    @Id
    @Column(name = "iddistribuidora")
    private int idDistribuidora;
    private String nombre;
    private String descripcion;
    private int fundacion;
    private String web;
    @ManyToOne
    @JoinColumn(name = "idsede")
    private Paises sede;
}
