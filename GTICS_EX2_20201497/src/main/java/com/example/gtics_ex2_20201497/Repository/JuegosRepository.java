package com.example.gtics_ex2_20201497.Repository;

import com.example.gtics_ex2_20201497.Entity.Juegos;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegosRepository extends JpaRepository<Juegos, Integer> {
}
