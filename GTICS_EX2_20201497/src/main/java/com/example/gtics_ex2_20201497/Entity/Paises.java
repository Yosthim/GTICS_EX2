package com.example.gtics_ex2_20201497.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paises")
public class Paises {
    @Id
    @Column(name = "idpais")
    private int idPais;
    private char iso;
    private String nombre;
}
