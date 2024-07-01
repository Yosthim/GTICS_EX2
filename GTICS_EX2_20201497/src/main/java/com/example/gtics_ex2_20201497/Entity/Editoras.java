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
@Table(name = "editoras")
@JsonIgnoreProperties({"idEditora"})
public class Editoras {
    @Id
    @Column(name = "ideditora")
    private int idEditora;
    private String nombre;
    private String descripcion;
}
