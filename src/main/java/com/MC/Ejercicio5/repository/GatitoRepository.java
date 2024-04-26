package com.MC.Ejercicio5.repository;

import com.MC.Ejercicio5.entity.Gatito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GatitoRepository extends JpaRepository<Gatito, Long> {
    @Query("SELECT g FROM Gatito g WHERE g.edad >= :edad")
    List<Gatito> findByMayorEdad(@Param("edad") int edad);
}
