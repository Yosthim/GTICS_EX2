package com.example.gtics_ex2_20201497.Repository;

import com.example.gtics_ex2_20201497.Entity.Distribuidoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuidorasRepository extends JpaRepository<Distribuidoras, Integer> {
}
